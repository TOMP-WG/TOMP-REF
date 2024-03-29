# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.token_data import TokenData  # noqa: F401,E501
from swagger_server import util


class Token(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, valid_from: datetime=None, valid_until: datetime=None, token_type: str=None, token_data: TokenData=None):  # noqa: E501
        """Token - a model defined in Swagger

        :param valid_from: The valid_from of this Token.  # noqa: E501
        :type valid_from: datetime
        :param valid_until: The valid_until of this Token.  # noqa: E501
        :type valid_until: datetime
        :param token_type: The token_type of this Token.  # noqa: E501
        :type token_type: str
        :param token_data: The token_data of this Token.  # noqa: E501
        :type token_data: TokenData
        """
        self.swagger_types = {
            'valid_from': datetime,
            'valid_until': datetime,
            'token_type': str,
            'token_data': TokenData
        }

        self.attribute_map = {
            'valid_from': 'validFrom',
            'valid_until': 'validUntil',
            'token_type': 'tokenType',
            'token_data': 'tokenData'
        }
        self._valid_from = valid_from
        self._valid_until = valid_until
        self._token_type = token_type
        self._token_data = token_data

    @classmethod
    def from_dict(cls, dikt) -> 'Token':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The token of this Token.  # noqa: E501
        :rtype: Token
        """
        return util.deserialize_model(dikt, cls)

    @property
    def valid_from(self) -> datetime:
        """Gets the valid_from of this Token.


        :return: The valid_from of this Token.
        :rtype: datetime
        """
        return self._valid_from

    @valid_from.setter
    def valid_from(self, valid_from: datetime):
        """Sets the valid_from of this Token.


        :param valid_from: The valid_from of this Token.
        :type valid_from: datetime
        """
        if valid_from is None:
            raise ValueError("Invalid value for `valid_from`, must not be `None`")  # noqa: E501

        self._valid_from = valid_from

    @property
    def valid_until(self) -> datetime:
        """Gets the valid_until of this Token.


        :return: The valid_until of this Token.
        :rtype: datetime
        """
        return self._valid_until

    @valid_until.setter
    def valid_until(self, valid_until: datetime):
        """Sets the valid_until of this Token.


        :param valid_until: The valid_until of this Token.
        :type valid_until: datetime
        """
        if valid_until is None:
            raise ValueError("Invalid value for `valid_until`, must not be `None`")  # noqa: E501

        self._valid_until = valid_until

    @property
    def token_type(self) -> str:
        """Gets the token_type of this Token.

        The type of data held in this token, will later be an enum  # noqa: E501

        :return: The token_type of this Token.
        :rtype: str
        """
        return self._token_type

    @token_type.setter
    def token_type(self, token_type: str):
        """Sets the token_type of this Token.

        The type of data held in this token, will later be an enum  # noqa: E501

        :param token_type: The token_type of this Token.
        :type token_type: str
        """
        if token_type is None:
            raise ValueError("Invalid value for `token_type`, must not be `None`")  # noqa: E501

        self._token_type = token_type

    @property
    def token_data(self) -> TokenData:
        """Gets the token_data of this Token.


        :return: The token_data of this Token.
        :rtype: TokenData
        """
        return self._token_data

    @token_data.setter
    def token_data(self, token_data: TokenData):
        """Sets the token_data of this Token.


        :param token_data: The token_data of this Token.
        :type token_data: TokenData
        """

        self._token_data = token_data
