from typing import List
"""
controller generated to handled auth operation described at:
https://connexion.readthedocs.io/en/latest/security.html
"""
def check_ApiKeyAuth(api_key, required_scopes):
    return {'test_key': 'test_value'}

def check_BasicAuth(username, password, required_scopes):
    return {'test_key': 'test_value'}

def check_BearerAuth(token):
    return {'test_key': 'test_value'}

def check_OAuth(token):
    return {'scopes': ['read:pets', 'write:pets'], 'uid': 'test_value'}

def validate_scope_OAuth(required_scopes, token_scopes):
    return set(required_scopes).issubset(set(token_scopes))


