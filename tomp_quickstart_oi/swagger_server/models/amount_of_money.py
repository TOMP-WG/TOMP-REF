# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.country import Country  # noqa: F401,E501
from swagger_server import util


class AmountOfMoney(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, amount: float=None, amount_ex_vat: float=None, currency_code: str=None, vat_rate: float=None, vat_country_code: Country=None):  # noqa: E501
        """AmountOfMoney - a model defined in Swagger

        :param amount: The amount of this AmountOfMoney.  # noqa: E501
        :type amount: float
        :param amount_ex_vat: The amount_ex_vat of this AmountOfMoney.  # noqa: E501
        :type amount_ex_vat: float
        :param currency_code: The currency_code of this AmountOfMoney.  # noqa: E501
        :type currency_code: str
        :param vat_rate: The vat_rate of this AmountOfMoney.  # noqa: E501
        :type vat_rate: float
        :param vat_country_code: The vat_country_code of this AmountOfMoney.  # noqa: E501
        :type vat_country_code: Country
        """
        self.swagger_types = {
            'amount': float,
            'amount_ex_vat': float,
            'currency_code': str,
            'vat_rate': float,
            'vat_country_code': Country
        }

        self.attribute_map = {
            'amount': 'amount',
            'amount_ex_vat': 'amountExVat',
            'currency_code': 'currencyCode',
            'vat_rate': 'vatRate',
            'vat_country_code': 'vatCountryCode'
        }
        self._amount = amount
        self._amount_ex_vat = amount_ex_vat
        self._currency_code = currency_code
        self._vat_rate = vat_rate
        self._vat_country_code = vat_country_code

    @classmethod
    def from_dict(cls, dikt) -> 'AmountOfMoney':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The amountOfMoney of this AmountOfMoney.  # noqa: E501
        :rtype: AmountOfMoney
        """
        return util.deserialize_model(dikt, cls)

    @property
    def amount(self) -> float:
        """Gets the amount of this AmountOfMoney.

        This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT  # noqa: E501

        :return: The amount of this AmountOfMoney.
        :rtype: float
        """
        return self._amount

    @amount.setter
    def amount(self, amount: float):
        """Sets the amount of this AmountOfMoney.

        This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT  # noqa: E501

        :param amount: The amount of this AmountOfMoney.
        :type amount: float
        """

        self._amount = amount

    @property
    def amount_ex_vat(self) -> float:
        """Gets the amount_ex_vat of this AmountOfMoney.


        :return: The amount_ex_vat of this AmountOfMoney.
        :rtype: float
        """
        return self._amount_ex_vat

    @amount_ex_vat.setter
    def amount_ex_vat(self, amount_ex_vat: float):
        """Sets the amount_ex_vat of this AmountOfMoney.


        :param amount_ex_vat: The amount_ex_vat of this AmountOfMoney.
        :type amount_ex_vat: float
        """

        self._amount_ex_vat = amount_ex_vat

    @property
    def currency_code(self) -> str:
        """Gets the currency_code of this AmountOfMoney.

        ISO 4217 currency code  # noqa: E501

        :return: The currency_code of this AmountOfMoney.
        :rtype: str
        """
        return self._currency_code

    @currency_code.setter
    def currency_code(self, currency_code: str):
        """Sets the currency_code of this AmountOfMoney.

        ISO 4217 currency code  # noqa: E501

        :param currency_code: The currency_code of this AmountOfMoney.
        :type currency_code: str
        """

        self._currency_code = currency_code

    @property
    def vat_rate(self) -> float:
        """Gets the vat_rate of this AmountOfMoney.

        value added tax rate (percentage of amount)  # noqa: E501

        :return: The vat_rate of this AmountOfMoney.
        :rtype: float
        """
        return self._vat_rate

    @vat_rate.setter
    def vat_rate(self, vat_rate: float):
        """Sets the vat_rate of this AmountOfMoney.

        value added tax rate (percentage of amount)  # noqa: E501

        :param vat_rate: The vat_rate of this AmountOfMoney.
        :type vat_rate: float
        """

        self._vat_rate = vat_rate

    @property
    def vat_country_code(self) -> Country:
        """Gets the vat_country_code of this AmountOfMoney.


        :return: The vat_country_code of this AmountOfMoney.
        :rtype: Country
        """
        return self._vat_country_code

    @vat_country_code.setter
    def vat_country_code(self, vat_country_code: Country):
        """Sets the vat_country_code of this AmountOfMoney.


        :param vat_country_code: The vat_country_code of this AmountOfMoney.
        :type vat_country_code: Country
        """

        self._vat_country_code = vat_country_code