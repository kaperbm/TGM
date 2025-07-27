# controller.py
class Controller:
    """Controller class that connects the view and model."""

    def __init__(self, model, view):
        self.model = model
        self.view = view
        self.connect_signals()

    def connect_signals(self):
        """Connects view buttons to their respective functions."""
        self.view.convert_button.clicked.connect(self.convert_currency)
        self.view.reset_button.clicked.connect(self.reset_fields)
        self.view.exit_button.clicked.connect(self.view.close)

    def convert_currency(self):
        """Handles the conversion logic and updates the view."""
        amount = self.view.amount_input.value()
        base_currency = self.view.base_currency_input.text().upper()
        target_currencies = self.view.target_currency_input.text().upper()
        result = f"{amount} {base_currency} equals:\n"
        date = None

        for currency in target_currencies.split(','):
            currency = currency.strip()
            response_data = self.model.convert(amount, base_currency, currency)

            if "error" in response_data:
                result += f"Error for {currency}: {response_data['error']}\n"
                self.view.status_bar.showMessage(f"Error for {currency}: {response_data['error']}", 5000)
                self.view.status_bar.showMessage("Conversion failed", 5000)
            elif 'result' not in response_data:
                result += f"Unexpected response for {currency}: {response_data}\n"
                self.view.status_bar.showMessage(f"Unexpected response for {currency}", 5000)

            else:
                converted_amount = response_data['result']
                rate = response_data['info']['rate']
                result += (f"• {converted_amount:.2f} {currency} (Rate: {rate:.5f})\n")
                if not date:
                    date = response_data.get('date')
                self.view.status_bar.showMessage("Conversion successful", 5000)
        if date:
            result += f"\nAs of: {date}"

        self.view.result_display.setText(result)




    def reset_fields(self):
        """Resets all fields and clears messages."""
        self.view.amount_input.setValue(0)
        self.view.base_currency_input.setText("")
        self.view.target_currency_input.setText("")
        self.view.result_display.clear()
        self.view.status_bar.clearMessage()
