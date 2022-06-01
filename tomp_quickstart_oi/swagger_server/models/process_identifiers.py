# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server import util


class ProcessIdentifiers(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, operator_information: List[str]=None, planning: List[str]=None, booking: List[str]=None, trip_execution: List[str]=None, support: List[str]=None, payment: List[str]=None, general: List[str]=None):  # noqa: E501
        """ProcessIdentifiers - a model defined in Swagger

        :param operator_information: The operator_information of this ProcessIdentifiers.  # noqa: E501
        :type operator_information: List[str]
        :param planning: The planning of this ProcessIdentifiers.  # noqa: E501
        :type planning: List[str]
        :param booking: The booking of this ProcessIdentifiers.  # noqa: E501
        :type booking: List[str]
        :param trip_execution: The trip_execution of this ProcessIdentifiers.  # noqa: E501
        :type trip_execution: List[str]
        :param support: The support of this ProcessIdentifiers.  # noqa: E501
        :type support: List[str]
        :param payment: The payment of this ProcessIdentifiers.  # noqa: E501
        :type payment: List[str]
        :param general: The general of this ProcessIdentifiers.  # noqa: E501
        :type general: List[str]
        """
        self.swagger_types = {
            'operator_information': List[str],
            'planning': List[str],
            'booking': List[str],
            'trip_execution': List[str],
            'support': List[str],
            'payment': List[str],
            'general': List[str]
        }

        self.attribute_map = {
            'operator_information': 'operatorInformation',
            'planning': 'planning',
            'booking': 'booking',
            'trip_execution': 'tripExecution',
            'support': 'support',
            'payment': 'payment',
            'general': 'general'
        }
        self._operator_information = operator_information
        self._planning = planning
        self._booking = booking
        self._trip_execution = trip_execution
        self._support = support
        self._payment = payment
        self._general = general

    @classmethod
    def from_dict(cls, dikt) -> 'ProcessIdentifiers':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The processIdentifiers of this ProcessIdentifiers.  # noqa: E501
        :rtype: ProcessIdentifiers
        """
        return util.deserialize_model(dikt, cls)

    @property
    def operator_information(self) -> List[str]:
        """Gets the operator_information of this ProcessIdentifiers.


        :return: The operator_information of this ProcessIdentifiers.
        :rtype: List[str]
        """
        return self._operator_information

    @operator_information.setter
    def operator_information(self, operator_information: List[str]):
        """Sets the operator_information of this ProcessIdentifiers.


        :param operator_information: The operator_information of this ProcessIdentifiers.
        :type operator_information: List[str]
        """
        if operator_information is None:
            raise ValueError("Invalid value for `operator_information`, must not be `None`")  # noqa: E501

        self._operator_information = operator_information

    @property
    def planning(self) -> List[str]:
        """Gets the planning of this ProcessIdentifiers.


        :return: The planning of this ProcessIdentifiers.
        :rtype: List[str]
        """
        return self._planning

    @planning.setter
    def planning(self, planning: List[str]):
        """Sets the planning of this ProcessIdentifiers.


        :param planning: The planning of this ProcessIdentifiers.
        :type planning: List[str]
        """
        if planning is None:
            raise ValueError("Invalid value for `planning`, must not be `None`")  # noqa: E501

        self._planning = planning

    @property
    def booking(self) -> List[str]:
        """Gets the booking of this ProcessIdentifiers.


        :return: The booking of this ProcessIdentifiers.
        :rtype: List[str]
        """
        return self._booking

    @booking.setter
    def booking(self, booking: List[str]):
        """Sets the booking of this ProcessIdentifiers.


        :param booking: The booking of this ProcessIdentifiers.
        :type booking: List[str]
        """
        if booking is None:
            raise ValueError("Invalid value for `booking`, must not be `None`")  # noqa: E501

        self._booking = booking

    @property
    def trip_execution(self) -> List[str]:
        """Gets the trip_execution of this ProcessIdentifiers.


        :return: The trip_execution of this ProcessIdentifiers.
        :rtype: List[str]
        """
        return self._trip_execution

    @trip_execution.setter
    def trip_execution(self, trip_execution: List[str]):
        """Sets the trip_execution of this ProcessIdentifiers.


        :param trip_execution: The trip_execution of this ProcessIdentifiers.
        :type trip_execution: List[str]
        """
        if trip_execution is None:
            raise ValueError("Invalid value for `trip_execution`, must not be `None`")  # noqa: E501

        self._trip_execution = trip_execution

    @property
    def support(self) -> List[str]:
        """Gets the support of this ProcessIdentifiers.


        :return: The support of this ProcessIdentifiers.
        :rtype: List[str]
        """
        return self._support

    @support.setter
    def support(self, support: List[str]):
        """Sets the support of this ProcessIdentifiers.


        :param support: The support of this ProcessIdentifiers.
        :type support: List[str]
        """
        if support is None:
            raise ValueError("Invalid value for `support`, must not be `None`")  # noqa: E501

        self._support = support

    @property
    def payment(self) -> List[str]:
        """Gets the payment of this ProcessIdentifiers.


        :return: The payment of this ProcessIdentifiers.
        :rtype: List[str]
        """
        return self._payment

    @payment.setter
    def payment(self, payment: List[str]):
        """Sets the payment of this ProcessIdentifiers.


        :param payment: The payment of this ProcessIdentifiers.
        :type payment: List[str]
        """
        if payment is None:
            raise ValueError("Invalid value for `payment`, must not be `None`")  # noqa: E501

        self._payment = payment

    @property
    def general(self) -> List[str]:
        """Gets the general of this ProcessIdentifiers.


        :return: The general of this ProcessIdentifiers.
        :rtype: List[str]
        """
        return self._general

    @general.setter
    def general(self, general: List[str]):
        """Sets the general of this ProcessIdentifiers.


        :param general: The general of this ProcessIdentifiers.
        :type general: List[str]
        """
        if general is None:
            raise ValueError("Invalid value for `general`, must not be `None`")  # noqa: E501

        self._general = general