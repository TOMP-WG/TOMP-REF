import json
import logging
import os
from base.config_util import ConfigUtil as config

class JsonUtil:
    def get_real_file(file):
        real_file = './external/' + file
        if os.path.exists(real_file):
            return real_file
        config_path = config.read_config_value('modality')
        if config_path != None:
            real_file = './' + config_path + '/' + file
            if os.path.exists( real_file ):
                return real_file
        return './default/' + file
        
    def read_all_json(json_file):
        real_file = JsonUtil.get_real_file(json_file)
        try:
            with open(real_file, "r") as json_file:
                return json.load(json_file)
        except Exception as e:
            logging.error("An exception occurred:", e)
            raise e
