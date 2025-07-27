plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit Test-Abhängigkeiten
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // JSON-Bibliothek hinzufügen
    implementation("org.json:json:20210307")
}

tasks.test {
    useJUnitPlatform()
}
