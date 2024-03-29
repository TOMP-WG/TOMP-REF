# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.asset_class import AssetClass  # noqa: F401,E501
from swagger_server.models.card_type import CardType  # noqa: F401,E501
from swagger_server.models.country import Country  # noqa: F401,E501
from swagger_server import util


class Card(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, type: str=None, sub_type: str=None, asset_class: AssetClass=None, acceptors: List[str]=None, card_description: str=None, card_number: str=None, card_additional_number: str=None, valid_until: date=None, country: Country=None):  # noqa: E501
        """Card - a model defined in Swagger

        :param type: The type of this Card.  # noqa: E501
        :type type: str
        :param sub_type: The sub_type of this Card.  # noqa: E501
        :type sub_type: str
        :param asset_class: The asset_class of this Card.  # noqa: E501
        :type asset_class: AssetClass
        :param acceptors: The acceptors of this Card.  # noqa: E501
        :type acceptors: List[str]
        :param card_description: The card_description of this Card.  # noqa: E501
        :type card_description: str
        :param card_number: The card_number of this Card.  # noqa: E501
        :type card_number: str
        :param card_additional_number: The card_additional_number of this Card.  # noqa: E501
        :type card_additional_number: str
        :param valid_until: The valid_until of this Card.  # noqa: E501
        :type valid_until: date
        :param country: The country of this Card.  # noqa: E501
        :type country: Country
        """
        self.swagger_types = {
            'type': str,
            'sub_type': str,
            'asset_class': AssetClass,
            'acceptors': List[str],
            'card_description': str,
            'card_number': str,
            'card_additional_number': str,
            'valid_until': date,
            'country': Country
        }

        self.attribute_map = {
            'type': 'type',
            'sub_type': 'subType',
            'asset_class': 'assetClass',
            'acceptors': 'acceptors',
            'card_description': 'cardDescription',
            'card_number': 'cardNumber',
            'card_additional_number': 'cardAdditionalNumber',
            'valid_until': 'validUntil',
            'country': 'country'
        }
        self._type = type
        self._sub_type = sub_type
        self._asset_class = asset_class
        self._acceptors = acceptors
        self._card_description = card_description
        self._card_number = card_number
        self._card_additional_number = card_additional_number
        self._valid_until = valid_until
        self._country = country

    @classmethod
    def from_dict(cls, dikt) -> 'Card':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The card of this Card.  # noqa: E501
        :rtype: Card
        """
        return util.deserialize_model(dikt, cls)

    @property
    def type(self) -> str:
        """Gets the type of this Card.

        The broad category of card  # noqa: E501

        :return: The type of this Card.
        :rtype: str
        """
        return self._type

    @type.setter
    def type(self, type: str):
        """Sets the type of this Card.

        The broad category of card  # noqa: E501

        :param type: The type of this Card.
        :type type: str
        """
        allowed_values = ["ID", "DISCOUNT", "TRAVEL", "BANK", "CREDIT", "PASSPORT", "OTHER"]  # noqa: E501
        if type not in allowed_values:
            raise ValueError(
                "Invalid value for `type` ({0}), must be one of {1}"
                .format(type, allowed_values)
            )

        self._type = type

    @property
    def sub_type(self) -> str:
        """Gets the sub_type of this Card.

        For use in case of OTHER. Can be used in bilateral agreements.  # noqa: E501

        :return: The sub_type of this Card.
        :rtype: str
        """
        return self._sub_type

    @sub_type.setter
    def sub_type(self, sub_type: str):
        """Sets the sub_type of this Card.

        For use in case of OTHER. Can be used in bilateral agreements.  # noqa: E501

        :param sub_type: The sub_type of this Card.
        :type sub_type: str
        """

        self._sub_type = sub_type

    @property
    def asset_class(self) -> AssetClass:
        """Gets the asset_class of this Card.


        :return: The asset_class of this Card.
        :rtype: AssetClass
        """
        return self._asset_class

    @asset_class.setter
    def asset_class(self, asset_class: AssetClass):
        """Sets the asset_class of this Card.


        :param asset_class: The asset_class of this Card.
        :type asset_class: AssetClass
        """

        self._asset_class = asset_class

    @property
    def acceptors(self) -> List[str]:
        """Gets the acceptors of this Card.

        references to accepting parties, only if applicable  # noqa: E501

        :return: The acceptors of this Card.
        :rtype: List[str]
        """
        return self._acceptors

    @acceptors.setter
    def acceptors(self, acceptors: List[str]):
        """Sets the acceptors of this Card.

        references to accepting parties, only if applicable  # noqa: E501

        :param acceptors: The acceptors of this Card.
        :type acceptors: List[str]
        """

        self._acceptors = acceptors

    @property
    def card_description(self) -> str:
        """Gets the card_description of this Card.

        description of the card  # noqa: E501

        :return: The card_description of this Card.
        :rtype: str
        """
        return self._card_description

    @card_description.setter
    def card_description(self, card_description: str):
        """Sets the card_description of this Card.

        description of the card  # noqa: E501

        :param card_description: The card_description of this Card.
        :type card_description: str
        """

        self._card_description = card_description

    @property
    def card_number(self) -> str:
        """Gets the card_number of this Card.

        number of the card, like ID number, credit card or bank account number  # noqa: E501

        :return: The card_number of this Card.
        :rtype: str
        """
        return self._card_number

    @card_number.setter
    def card_number(self, card_number: str):
        """Sets the card_number of this Card.

        number of the card, like ID number, credit card or bank account number  # noqa: E501

        :param card_number: The card_number of this Card.
        :type card_number: str
        """
        if card_number is None:
            raise ValueError("Invalid value for `card_number`, must not be `None`")  # noqa: E501

        self._card_number = card_number

    @property
    def card_additional_number(self) -> str:
        """Gets the card_additional_number of this Card.

        additional number, like CVC code or IBAN code  # noqa: E501

        :return: The card_additional_number of this Card.
        :rtype: str
        """
        return self._card_additional_number

    @card_additional_number.setter
    def card_additional_number(self, card_additional_number: str):
        """Sets the card_additional_number of this Card.

        additional number, like CVC code or IBAN code  # noqa: E501

        :param card_additional_number: The card_additional_number of this Card.
        :type card_additional_number: str
        """

        self._card_additional_number = card_additional_number

    @property
    def valid_until(self) -> date:
        """Gets the valid_until of this Card.


        :return: The valid_until of this Card.
        :rtype: date
        """
        return self._valid_until

    @valid_until.setter
    def valid_until(self, valid_until: date):
        """Sets the valid_until of this Card.


        :param valid_until: The valid_until of this Card.
        :type valid_until: date
        """
        if valid_until is None:
            raise ValueError("Invalid value for `valid_until`, must not be `None`")  # noqa: E501

        self._valid_until = valid_until

    @property
    def country(self) -> Country:
        """Gets the country of this Card.


        :return: The country of this Card.
        :rtype: Country
        """
        return self._country

    @country.setter
    def country(self, country: Country):
        """Sets the country of this Card.


        :param country: The country of this Card.
        :type country: Country
        """

        self._country = country
