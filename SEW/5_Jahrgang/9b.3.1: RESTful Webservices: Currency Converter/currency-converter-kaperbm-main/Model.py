# model.py
import requests

class Model:
    API_URL = "http://api.apilayer.com/exchangerates_data/convert"
    API_KEY = "tkYuFDVAdGW8ijMhIzl46fQLNsOLOCMR"

    def convert(self, amount, base_currency, target_currency):
        url = f"{self.API_URL}?from={base_currency}&to={target_currency}&amount={amount}"
        headers = {"apikey": self.API_KEY}

        try:
            response = requests.get(url, headers=headers)
            if response.status_code == 200:
                return response.json()
            else:
                return {"error": f"Error: {response.status_code}"}
        except Exception as e:
            return {"error": str(e)}
