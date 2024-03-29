# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.condition import Condition  # noqa: F401,E501
from swagger_server import util


class ConditionRequireBookingData(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, condition_type: str=None, id: str=None, required_fields: List[str]=None, claims: List[str]=None):  # noqa: E501
        """ConditionRequireBookingData - a model defined in Swagger

        :param condition_type: The condition_type of this ConditionRequireBookingData.  # noqa: E501
        :type condition_type: str
        :param id: The id of this ConditionRequireBookingData.  # noqa: E501
        :type id: str
        :param required_fields: The required_fields of this ConditionRequireBookingData.  # noqa: E501
        :type required_fields: List[str]
        :param claims: The claims of this ConditionRequireBookingData.  # noqa: E501
        :type claims: List[str]
        """
        self.swagger_types = {
            'condition_type': str,
            'id': str,
            'required_fields': List[str],
            'claims': List[str]
        }

        self.attribute_map = {
            'condition_type': 'conditionType',
            'id': 'id',
            'required_fields': 'requiredFields',
            'claims': 'claims'
        }
        self._condition_type = condition_type
        self._id = id
        self._required_fields = required_fields
        self._claims = claims

    @classmethod
    def from_dict(cls, dikt) -> 'ConditionRequireBookingData':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The conditionRequireBookingData of this ConditionRequireBookingData.  # noqa: E501
        :rtype: ConditionRequireBookingData
        """
        return util.deserialize_model(dikt, cls)

    @property
    def condition_type(self) -> str:
        """Gets the condition_type of this ConditionRequireBookingData.

        The specific subclass of condition, should match the schema name exactly  # noqa: E501

        :return: The condition_type of this ConditionRequireBookingData.
        :rtype: str
        """
        return self._condition_type

    @condition_type.setter
    def condition_type(self, condition_type: str):
        """Sets the condition_type of this ConditionRequireBookingData.

        The specific subclass of condition, should match the schema name exactly  # noqa: E501

        :param condition_type: The condition_type of this ConditionRequireBookingData.
        :type condition_type: str
        """
        if condition_type is None:
            raise ValueError("Invalid value for `condition_type`, must not be `None`")  # noqa: E501

        self._condition_type = condition_type

    @property
    def id(self) -> str:
        """Gets the id of this ConditionRequireBookingData.

        An identifier for this condition that can be used to refer to this condition  # noqa: E501

        :return: The id of this ConditionRequireBookingData.
        :rtype: str
        """
        return self._id

    @id.setter
    def id(self, id: str):
        """Sets the id of this ConditionRequireBookingData.

        An identifier for this condition that can be used to refer to this condition  # noqa: E501

        :param id: The id of this ConditionRequireBookingData.
        :type id: str
        """

        self._id = id

    @property
    def required_fields(self) -> List[str]:
        """Gets the required_fields of this ConditionRequireBookingData.


        :return: The required_fields of this ConditionRequireBookingData.
        :rtype: List[str]
        """
        return self._required_fields

    @required_fields.setter
    def required_fields(self, required_fields: List[str]):
        """Sets the required_fields of this ConditionRequireBookingData.


        :param required_fields: The required_fields of this ConditionRequireBookingData.
        :type required_fields: List[str]
        """
        allowed_values = ["FROM_ADDRESS", "TO_ADDRESS", "BIRTHDATE", "EMAIL", "PERSONAL_ADDRESS", "PHONE_NUMBERS", "LICENSES", "BANK_CARDS", "DISCOUNT_CARDS", "TRAVEL_CARDS", "ID_CARDS", "CREDIT_CARDS", "NAME", "AGE", "BLOCKCHAIN_CLAIMS"]  # noqa: E501
        if not set(required_fields).issubset(set(allowed_values)):
            raise ValueError(
                "Invalid values for `required_fields` [{0}], must be a subset of [{1}]"  # noqa: E501
                .format(", ".join(map(str, set(required_fields) - set(allowed_values))),  # noqa: E501
                        ", ".join(map(str, allowed_values)))
            )

        self._required_fields = required_fields

    @property
    def claims(self) -> List[str]:
        """Gets the claims of this ConditionRequireBookingData.

        when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. On the WIKI page, the known ones are enlisted, but this list isn't finalized yet. https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials  # noqa: E501

        :return: The claims of this ConditionRequireBookingData.
        :rtype: List[str]
        """
        return self._claims

    @claims.setter
    def claims(self, claims: List[str]):
        """Sets the claims of this ConditionRequireBookingData.

        when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. On the WIKI page, the known ones are enlisted, but this list isn't finalized yet. https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials  # noqa: E501

        :param claims: The claims of this ConditionRequireBookingData.
        :type claims: List[str]
        """

        self._claims = claims
