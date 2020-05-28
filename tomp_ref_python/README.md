# Transport Operator Mobility API - Python reference implementation
This project contains a Python web application allowing developers to try out the [Transport Operator Mobility-as-a-Service Provider API](https://github.com/TOMP-WG/TOMP-API). It can also be used as the basis for further development.

## License
You are free to use and modify this project under the terms of the [Apache License 2.0](https://tldrlegal.com/license/apache-license-2.0-(apache-2.0)).

## Requirements
You will need the following requirements in order to run this project.

- Python 3.7+
- [Poetry](https://python-poetry.org/)

*Note:* We use the Poetry package manager because it is developer friendly, aligns with the Python PEP process, and supports dependency constraint resolving.

## Installing
With the above requirements met, you can install this app by running the following commands.

1. Create the virtual environment
```
poetry shell
```

2. Install project dependencies
```
poetry install
```

## Running
Once you have activated the Poetry environment and installed the dependencies, use the following command to run the server.

```
python app.py
```