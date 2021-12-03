import os

class ConfigUtil:
    def read_config_value(keyName):
        return os.getenv(keyName)
