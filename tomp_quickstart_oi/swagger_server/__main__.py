#!/usr/bin/env python3
import connexion

from swagger_server import encoder

def main():
    app = connexion.App(__name__, specification_dir='./swagger/')
    app.app.json_encoder = encoder.JSONEncoder
    app.add_api('swagger.yaml', arguments={'title': 'Transport Operator MaaS Provider API'}, pythonic_params=True)
    app.run(host="0.0.0.0", port=80)

if __name__ == '__main__':
    main()