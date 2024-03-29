# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.address import Address  # noqa: F401,E501
from swagger_server.models.coordinates import Coordinates  # noqa: F401,E501
from swagger_server.models.place import Place  # noqa: F401,E501
from swagger_server.models.stop_reference import StopReference  # noqa: F401,E501
from swagger_server import util


class AllOfbookingRequestFrom(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, name: str=None, stop_reference: List[StopReference]=None, station_id: str=None, coordinates: Coordinates=None, physical_address: Address=None, extra_info: Dict=None):  # noqa: E501
        """AllOfbookingRequestFrom - a model defined in Swagger

        :param name: The name of this AllOfbookingRequestFrom.  # noqa: E501
        :type name: str
        :param stop_reference: The stop_reference of this AllOfbookingRequestFrom.  # noqa: E501
        :type stop_reference: List[StopReference]
        :param station_id: The station_id of this AllOfbookingRequestFrom.  # noqa: E501
        :type station_id: str
        :param coordinates: The coordinates of this AllOfbookingRequestFrom.  # noqa: E501
        :type coordinates: Coordinates
        :param physical_address: The physical_address of this AllOfbookingRequestFrom.  # noqa: E501
        :type physical_address: Address
        :param extra_info: The extra_info of this AllOfbookingRequestFrom.  # noqa: E501
        :type extra_info: Dict
        """
        self.swagger_types = {
            'name': str,
            'stop_reference': List[StopReference],
            'station_id': str,
            'coordinates': Coordinates,
            'physical_address': Address,
            'extra_info': Dict
        }

        self.attribute_map = {
            'name': 'name',
            'stop_reference': 'stopReference',
            'station_id': 'stationId',
            'coordinates': 'coordinates',
            'physical_address': 'physicalAddress',
            'extra_info': 'extraInfo'
        }
        self._name = name
        self._stop_reference = stop_reference
        self._station_id = station_id
        self._coordinates = coordinates
        self._physical_address = physical_address
        self._extra_info = extra_info

    @classmethod
    def from_dict(cls, dikt) -> 'AllOfbookingRequestFrom':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The AllOfbookingRequestFrom of this AllOfbookingRequestFrom.  # noqa: E501
        :rtype: AllOfbookingRequestFrom
        """
        return util.deserialize_model(dikt, cls)

    @property
    def name(self) -> str:
        """Gets the name of this AllOfbookingRequestFrom.

        Human readable name of the place, could match Content-Language  # noqa: E501

        :return: The name of this AllOfbookingRequestFrom.
        :rtype: str
        """
        return self._name

    @name.setter
    def name(self, name: str):
        """Sets the name of this AllOfbookingRequestFrom.

        Human readable name of the place, could match Content-Language  # noqa: E501

        :param name: The name of this AllOfbookingRequestFrom.
        :type name: str
        """

        self._name = name

    @property
    def stop_reference(self) -> List[StopReference]:
        """Gets the stop_reference of this AllOfbookingRequestFrom.


        :return: The stop_reference of this AllOfbookingRequestFrom.
        :rtype: List[StopReference]
        """
        return self._stop_reference

    @stop_reference.setter
    def stop_reference(self, stop_reference: List[StopReference]):
        """Sets the stop_reference of this AllOfbookingRequestFrom.


        :param stop_reference: The stop_reference of this AllOfbookingRequestFrom.
        :type stop_reference: List[StopReference]
        """

        self._stop_reference = stop_reference

    @property
    def station_id(self) -> str:
        """Gets the station_id of this AllOfbookingRequestFrom.

        reference to /operator/stations  # noqa: E501

        :return: The station_id of this AllOfbookingRequestFrom.
        :rtype: str
        """
        return self._station_id

    @station_id.setter
    def station_id(self, station_id: str):
        """Sets the station_id of this AllOfbookingRequestFrom.

        reference to /operator/stations  # noqa: E501

        :param station_id: The station_id of this AllOfbookingRequestFrom.
        :type station_id: str
        """

        self._station_id = station_id

    @property
    def coordinates(self) -> Coordinates:
        """Gets the coordinates of this AllOfbookingRequestFrom.


        :return: The coordinates of this AllOfbookingRequestFrom.
        :rtype: Coordinates
        """
        return self._coordinates

    @coordinates.setter
    def coordinates(self, coordinates: Coordinates):
        """Sets the coordinates of this AllOfbookingRequestFrom.


        :param coordinates: The coordinates of this AllOfbookingRequestFrom.
        :type coordinates: Coordinates
        """
        if coordinates is None:
            raise ValueError("Invalid value for `coordinates`, must not be `None`")  # noqa: E501

        self._coordinates = coordinates

    @property
    def physical_address(self) -> Address:
        """Gets the physical_address of this AllOfbookingRequestFrom.


        :return: The physical_address of this AllOfbookingRequestFrom.
        :rtype: Address
        """
        return self._physical_address

    @physical_address.setter
    def physical_address(self, physical_address: Address):
        """Sets the physical_address of this AllOfbookingRequestFrom.


        :param physical_address: The physical_address of this AllOfbookingRequestFrom.
        :type physical_address: Address
        """

        self._physical_address = physical_address

    @property
    def extra_info(self) -> Dict:
        """Gets the extra_info of this AllOfbookingRequestFrom.


        :return: The extra_info of this AllOfbookingRequestFrom.
        :rtype: Dict
        """
        return self._extra_info

    @extra_info.setter
    def extra_info(self, extra_info: Dict):
        """Sets the extra_info of this AllOfbookingRequestFrom.


        :param extra_info: The extra_info of this AllOfbookingRequestFrom.
        :type extra_info: Dict
        """

        self._extra_info = extra_info
