# Cyclic Wagon Travels Finder

## Description

This project is designed to identify cyclic travels of wagons between stations, leveraging data processed from Excel files. Each wagon's journey is analyzed to detect cycles, which are defined as a return to the initial station. The algorithm efficiently processes large datasets, and as of February 8, 2024, it has analyzed 1,800,000 rows from two Excel files, identifying 229,000 cyclic movements.

## Getting Started

### Dependencies

- Java JDK 11 or higher
- Apache POI for Excel file processing
- Jackson for JSON handling
- Any IDE like IntelliJ IDEA or Eclipse

### Installation

1. Clone the repository to your local machine.
2. Ensure Java JDK 11 or higher is installed and properly set up.
3. Import the project into your IDE.
4. Resolve any dependencies, such as Apache POI and Jackson, which may require adding to your project's build path or `pom.xml` file if using Maven.

### Excel File Configuration

To run the algorithm, your Excel file columns must be named according to the `Data` object fields, as follows:

- `Номер вагона` (Wagon Number)
- `Станция отправления` (Departure Station)
- `Станция назначения` (Destination Station)
- `Код станции отправления` (Departure Station Code)
- `Код станции назначения` (Destination Station Code)
- `Номер отправки` (Dispatch Number)
- `Дата приема груза к перевозке` (Date of Dispatch)
- `Дата раскредитации` (Date of Delivery)
- `distance`
- `Вид отправки` (Type of Dispatch)

### Usage

1. Place your Excel files in the `resources` folder.
2. In `main`, adjust paths as needed and call the `extractWagonTravels` method from `ExtractDataFunctionImplementation` class to process the data.
3. Optionally, use the serialization and deserialization functions to save and load the processed data, avoiding reprocessing for each run.
4. Run `findCycles` algorithm to identify cyclic wagon travels. The results will be serialized into `results.json` and stored in the `resources` folder.

## Contributing

Your contributions are welcome! If you have suggestions for improving the algorithm or extending its capabilities, please feel free to fork the repository, make your changes, and submit a pull request.