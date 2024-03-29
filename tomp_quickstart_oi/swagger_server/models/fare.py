# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.fare_part import FarePart  # noqa: F401,E501
from swagger_server import util


class Fare(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, estimated: bool=None, description: str=None, _class: str=None, parts: List[FarePart]=None):  # noqa: E501
        """Fare - a model defined in Swagger

        :param estimated: The estimated of this Fare.  # noqa: E501
        :type estimated: bool
        :param description: The description of this Fare.  # noqa: E501
        :type description: str
        :param _class: The _class of this Fare.  # noqa: E501
        :type _class: str
        :param parts: The parts of this Fare.  # noqa: E501
        :type parts: List[FarePart]
        """
        self.swagger_types = {
            'estimated': bool,
            'description': str,
            '_class': str,
            'parts': List[FarePart]
        }

        self.attribute_map = {
            'estimated': 'estimated',
            'description': 'description',
            '_class': 'class',
            'parts': 'parts'
        }
        self._estimated = estimated
        self._description = description
        self.__class = _class
        self._parts = parts

    @classmethod
    def from_dict(cls, dikt) -> 'Fare':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The fare of this Fare.  # noqa: E501
        :rtype: Fare
        """
        return util.deserialize_model(dikt, cls)

    @property
    def estimated(self) -> bool:
        """Gets the estimated of this Fare.

        is this fare an estimation?  # noqa: E501

        :return: The estimated of this Fare.
        :rtype: bool
        """
        return self._estimated

    @estimated.setter
    def estimated(self, estimated: bool):
        """Sets the estimated of this Fare.

        is this fare an estimation?  # noqa: E501

        :param estimated: The estimated of this Fare.
        :type estimated: bool
        """
        if estimated is None:
            raise ValueError("Invalid value for `estimated`, must not be `None`")  # noqa: E501

        self._estimated = estimated

    @property
    def description(self) -> str:
        """Gets the description of this Fare.

        user friendly description of the fare (e.g. 'full fare'), should match Content-Language  # noqa: E501

        :return: The description of this Fare.
        :rtype: str
        """
        return self._description

    @description.setter
    def description(self, description: str):
        """Sets the description of this Fare.

        user friendly description of the fare (e.g. 'full fare'), should match Content-Language  # noqa: E501

        :param description: The description of this Fare.
        :type description: str
        """

        self._description = description

    @property
    def _class(self) -> str:
        """Gets the _class of this Fare.

        in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.  # noqa: E501

        :return: The _class of this Fare.
        :rtype: str
        """
        return self.__class

    @_class.setter
    def _class(self, _class: str):
        """Sets the _class of this Fare.

        in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.  # noqa: E501

        :param _class: The _class of this Fare.
        :type _class: str
        """

        self.__class = _class

    @property
    def parts(self) -> List[FarePart]:
        """Gets the parts of this Fare.


        :return: The parts of this Fare.
        :rtype: List[FarePart]
        """
        return self._parts

    @parts.setter
    def parts(self, parts: List[FarePart]):
        """Sets the parts of this Fare.


        :param parts: The parts of this Fare.
        :type parts: List[FarePart]
        """
        if parts is None:
            raise ValueError("Invalid value for `parts`, must not be `None`")  # noqa: E501

        self._parts = parts
