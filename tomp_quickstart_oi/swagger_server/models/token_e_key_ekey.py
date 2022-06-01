# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server import util


class TokenEKeyEkey(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, key: str=None, passkey: str=None):  # noqa: E501
        """TokenEKeyEkey - a model defined in Swagger

        :param key: The key of this TokenEKeyEkey.  # noqa: E501
        :type key: str
        :param passkey: The passkey of this TokenEKeyEkey.  # noqa: E501
        :type passkey: str
        """
        self.swagger_types = {
            'key': str,
            'passkey': str
        }

        self.attribute_map = {
            'key': 'key',
            'passkey': 'passkey'
        }
        self._key = key
        self._passkey = passkey

    @classmethod
    def from_dict(cls, dikt) -> 'TokenEKeyEkey':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The tokenEKey_ekey of this TokenEKeyEkey.  # noqa: E501
        :rtype: TokenEKeyEkey
        """
        return util.deserialize_model(dikt, cls)

    @property
    def key(self) -> str:
        """Gets the key of this TokenEKeyEkey.

        certificate  # noqa: E501

        :return: The key of this TokenEKeyEkey.
        :rtype: str
        """
        return self._key

    @key.setter
    def key(self, key: str):
        """Sets the key of this TokenEKeyEkey.

        certificate  # noqa: E501

        :param key: The key of this TokenEKeyEkey.
        :type key: str
        """

        self._key = key

    @property
    def passkey(self) -> str:
        """Gets the passkey of this TokenEKeyEkey.

        one time pass key  # noqa: E501

        :return: The passkey of this TokenEKeyEkey.
        :rtype: str
        """
        return self._passkey

    @passkey.setter
    def passkey(self, passkey: str):
        """Sets the passkey of this TokenEKeyEkey.

        one time pass key  # noqa: E501

        :param passkey: The passkey of this TokenEKeyEkey.
        :type passkey: str
        """

        self._passkey = passkey