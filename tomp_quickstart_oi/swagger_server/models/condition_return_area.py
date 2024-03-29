# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.condition import Condition  # noqa: F401,E501
from swagger_server.models.coordinates import Coordinates  # noqa: F401,E501
from swagger_server.models.system_hours import SystemHours  # noqa: F401,E501
from swagger_server import util


class ConditionReturnArea(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, condition_type: str=None, id: str=None, station_id: str=None, return_area: any=None, coordinates: Coordinates=None, return_hours: List[SystemHours]=None):  # noqa: E501
        """ConditionReturnArea - a model defined in Swagger

        :param condition_type: The condition_type of this ConditionReturnArea.  # noqa: E501
        :type condition_type: str
        :param id: The id of this ConditionReturnArea.  # noqa: E501
        :type id: str
        :param station_id: The station_id of this ConditionReturnArea.  # noqa: E501
        :type station_id: str
        :param return_area: The return_area of this ConditionReturnArea.  # noqa: E501
        :type return_area: any
        :param coordinates: The coordinates of this ConditionReturnArea.  # noqa: E501
        :type coordinates: Coordinates
        :param return_hours: The return_hours of this ConditionReturnArea.  # noqa: E501
        :type return_hours: List[SystemHours]
        """
        self.swagger_types = {
            'condition_type': str,
            'id': str,
            'station_id': str,
            'return_area': any,
            'coordinates': Coordinates,
            'return_hours': List[SystemHours]
        }

        self.attribute_map = {
            'condition_type': 'conditionType',
            'id': 'id',
            'station_id': 'stationId',
            'return_area': 'returnArea',
            'coordinates': 'coordinates',
            'return_hours': 'returnHours'
        }
        self._condition_type = condition_type
        self._id = id
        self._station_id = station_id
        self._return_area = return_area
        self._coordinates = coordinates
        self._return_hours = return_hours

    @classmethod
    def from_dict(cls, dikt) -> 'ConditionReturnArea':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The conditionReturnArea of this ConditionReturnArea.  # noqa: E501
        :rtype: ConditionReturnArea
        """
        return util.deserialize_model(dikt, cls)

    @property
    def condition_type(self) -> str:
        """Gets the condition_type of this ConditionReturnArea.

        The specific subclass of condition, should match the schema name exactly  # noqa: E501

        :return: The condition_type of this ConditionReturnArea.
        :rtype: str
        """
        return self._condition_type

    @condition_type.setter
    def condition_type(self, condition_type: str):
        """Sets the condition_type of this ConditionReturnArea.

        The specific subclass of condition, should match the schema name exactly  # noqa: E501

        :param condition_type: The condition_type of this ConditionReturnArea.
        :type condition_type: str
        """
        if condition_type is None:
            raise ValueError("Invalid value for `condition_type`, must not be `None`")  # noqa: E501

        self._condition_type = condition_type

    @property
    def id(self) -> str:
        """Gets the id of this ConditionReturnArea.

        An identifier for this condition that can be used to refer to this condition  # noqa: E501

        :return: The id of this ConditionReturnArea.
        :rtype: str
        """
        return self._id

    @id.setter
    def id(self, id: str):
        """Sets the id of this ConditionReturnArea.

        An identifier for this condition that can be used to refer to this condition  # noqa: E501

        :param id: The id of this ConditionReturnArea.
        :type id: str
        """

        self._id = id

    @property
    def station_id(self) -> str:
        """Gets the station_id of this ConditionReturnArea.

        station to which the asset should be returned  # noqa: E501

        :return: The station_id of this ConditionReturnArea.
        :rtype: str
        """
        return self._station_id

    @station_id.setter
    def station_id(self, station_id: str):
        """Sets the station_id of this ConditionReturnArea.

        station to which the asset should be returned  # noqa: E501

        :param station_id: The station_id of this ConditionReturnArea.
        :type station_id: str
        """

        self._station_id = station_id

    @property
    def return_area(self) -> any:
        """Gets the return_area of this ConditionReturnArea.

        area in which the asset should be returned as GeoJSON Polygon coordinates  # noqa: E501

        :return: The return_area of this ConditionReturnArea.
        :rtype: any
        """
        return self._return_area

    @return_area.setter
    def return_area(self, return_area: any):
        """Sets the return_area of this ConditionReturnArea.

        area in which the asset should be returned as GeoJSON Polygon coordinates  # noqa: E501

        :param return_area: The return_area of this ConditionReturnArea.
        :type return_area: any
        """

        self._return_area = return_area

    @property
    def coordinates(self) -> Coordinates:
        """Gets the coordinates of this ConditionReturnArea.


        :return: The coordinates of this ConditionReturnArea.
        :rtype: Coordinates
        """
        return self._coordinates

    @coordinates.setter
    def coordinates(self, coordinates: Coordinates):
        """Sets the coordinates of this ConditionReturnArea.


        :param coordinates: The coordinates of this ConditionReturnArea.
        :type coordinates: Coordinates
        """

        self._coordinates = coordinates

    @property
    def return_hours(self) -> List[SystemHours]:
        """Gets the return_hours of this ConditionReturnArea.

        the return hours of the facility (if different from operating-hours)  # noqa: E501

        :return: The return_hours of this ConditionReturnArea.
        :rtype: List[SystemHours]
        """
        return self._return_hours

    @return_hours.setter
    def return_hours(self, return_hours: List[SystemHours]):
        """Sets the return_hours of this ConditionReturnArea.

        the return hours of the facility (if different from operating-hours)  # noqa: E501

        :param return_hours: The return_hours of this ConditionReturnArea.
        :type return_hours: List[SystemHours]
        """

        self._return_hours = return_hours
