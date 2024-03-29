# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.token_data import TokenData  # noqa: F401,E501
from swagger_server.models.token_e_key_ekey import TokenEKeyEkey  # noqa: F401,E501
from swagger_server.models.token_e_key_lock import TokenEKeyLock  # noqa: F401,E501
from swagger_server import util


class TokenEKey(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, token_type: str=None, ekey: TokenEKeyEkey=None, lock: TokenEKeyLock=None):  # noqa: E501
        """TokenEKey - a model defined in Swagger

        :param token_type: The token_type of this TokenEKey.  # noqa: E501
        :type token_type: str
        :param ekey: The ekey of this TokenEKey.  # noqa: E501
        :type ekey: TokenEKeyEkey
        :param lock: The lock of this TokenEKey.  # noqa: E501
        :type lock: TokenEKeyLock
        """
        self.swagger_types = {
            'token_type': str,
            'ekey': TokenEKeyEkey,
            'lock': TokenEKeyLock
        }

        self.attribute_map = {
            'token_type': 'tokenType',
            'ekey': 'ekey',
            'lock': 'lock'
        }
        self._token_type = token_type
        self._ekey = ekey
        self._lock = lock

    @classmethod
    def from_dict(cls, dikt) -> 'TokenEKey':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The tokenEKey of this TokenEKey.  # noqa: E501
        :rtype: TokenEKey
        """
        return util.deserialize_model(dikt, cls)

    @property
    def token_type(self) -> str:
        """Gets the token_type of this TokenEKey.


        :return: The token_type of this TokenEKey.
        :rtype: str
        """
        return self._token_type

    @token_type.setter
    def token_type(self, token_type: str):
        """Sets the token_type of this TokenEKey.


        :param token_type: The token_type of this TokenEKey.
        :type token_type: str
        """
        if token_type is None:
            raise ValueError("Invalid value for `token_type`, must not be `None`")  # noqa: E501

        self._token_type = token_type

    @property
    def ekey(self) -> TokenEKeyEkey:
        """Gets the ekey of this TokenEKey.


        :return: The ekey of this TokenEKey.
        :rtype: TokenEKeyEkey
        """
        return self._ekey

    @ekey.setter
    def ekey(self, ekey: TokenEKeyEkey):
        """Sets the ekey of this TokenEKey.


        :param ekey: The ekey of this TokenEKey.
        :type ekey: TokenEKeyEkey
        """
        if ekey is None:
            raise ValueError("Invalid value for `ekey`, must not be `None`")  # noqa: E501

        self._ekey = ekey

    @property
    def lock(self) -> TokenEKeyLock:
        """Gets the lock of this TokenEKey.


        :return: The lock of this TokenEKey.
        :rtype: TokenEKeyLock
        """
        return self._lock

    @lock.setter
    def lock(self, lock: TokenEKeyLock):
        """Sets the lock of this TokenEKey.


        :param lock: The lock of this TokenEKey.
        :type lock: TokenEKeyLock
        """
        if lock is None:
            raise ValueError("Invalid value for `lock`, must not be `None`")  # noqa: E501

        self._lock = lock
