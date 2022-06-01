# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.asset import Asset  # noqa: F401,E501
from swagger_server.models.asset_class import AssetClass  # noqa: F401,E501
from swagger_server.models.asset_properties import AssetProperties  # noqa: F401,E501
from swagger_server.models.condition import Condition  # noqa: F401,E501
from swagger_server.models.system_pricing_plan import SystemPricingPlan  # noqa: F401,E501
from swagger_server import util


class AssetType(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, id: str=None, station_id: str=None, nr_available: int=None, assets: List[Asset]=None, asset_class: AssetClass=None, asset_sub_class: str=None, shared_properties: AssetProperties=None, applicable_pricings: List[SystemPricingPlan]=None, conditions: List[Condition]=None):  # noqa: E501
        """AssetType - a model defined in Swagger

        :param id: The id of this AssetType.  # noqa: E501
        :type id: str
        :param station_id: The station_id of this AssetType.  # noqa: E501
        :type station_id: str
        :param nr_available: The nr_available of this AssetType.  # noqa: E501
        :type nr_available: int
        :param assets: The assets of this AssetType.  # noqa: E501
        :type assets: List[Asset]
        :param asset_class: The asset_class of this AssetType.  # noqa: E501
        :type asset_class: AssetClass
        :param asset_sub_class: The asset_sub_class of this AssetType.  # noqa: E501
        :type asset_sub_class: str
        :param shared_properties: The shared_properties of this AssetType.  # noqa: E501
        :type shared_properties: AssetProperties
        :param applicable_pricings: The applicable_pricings of this AssetType.  # noqa: E501
        :type applicable_pricings: List[SystemPricingPlan]
        :param conditions: The conditions of this AssetType.  # noqa: E501
        :type conditions: List[Condition]
        """
        self.swagger_types = {
            'id': str,
            'station_id': str,
            'nr_available': int,
            'assets': List[Asset],
            'asset_class': AssetClass,
            'asset_sub_class': str,
            'shared_properties': AssetProperties,
            'applicable_pricings': List[SystemPricingPlan],
            'conditions': List[Condition]
        }

        self.attribute_map = {
            'id': 'id',
            'station_id': 'stationId',
            'nr_available': 'nrAvailable',
            'assets': 'assets',
            'asset_class': 'assetClass',
            'asset_sub_class': 'assetSubClass',
            'shared_properties': 'sharedProperties',
            'applicable_pricings': 'applicablePricings',
            'conditions': 'conditions'
        }
        self._id = id
        self._station_id = station_id
        self._nr_available = nr_available
        self._assets = assets
        self._asset_class = asset_class
        self._asset_sub_class = asset_sub_class
        self._shared_properties = shared_properties
        self._applicable_pricings = applicable_pricings
        self._conditions = conditions

    @classmethod
    def from_dict(cls, dikt) -> 'AssetType':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The assetType of this AssetType.  # noqa: E501
        :rtype: AssetType
        """
        return util.deserialize_model(dikt, cls)

    @property
    def id(self) -> str:
        """Gets the id of this AssetType.

        Unique identifier of an asset type,  # noqa: E501

        :return: The id of this AssetType.
        :rtype: str
        """
        return self._id

    @id.setter
    def id(self, id: str):
        """Sets the id of this AssetType.

        Unique identifier of an asset type,  # noqa: E501

        :param id: The id of this AssetType.
        :type id: str
        """
        if id is None:
            raise ValueError("Invalid value for `id`, must not be `None`")  # noqa: E501

        self._id = id

    @property
    def station_id(self) -> str:
        """Gets the station_id of this AssetType.

        If stationId is present, the nrAvailable is expected to find the availability at that particular station  # noqa: E501

        :return: The station_id of this AssetType.
        :rtype: str
        """
        return self._station_id

    @station_id.setter
    def station_id(self, station_id: str):
        """Sets the station_id of this AssetType.

        If stationId is present, the nrAvailable is expected to find the availability at that particular station  # noqa: E501

        :param station_id: The station_id of this AssetType.
        :type station_id: str
        """

        self._station_id = station_id

    @property
    def nr_available(self) -> int:
        """Gets the nr_available of this AssetType.


        :return: The nr_available of this AssetType.
        :rtype: int
        """
        return self._nr_available

    @nr_available.setter
    def nr_available(self, nr_available: int):
        """Sets the nr_available of this AssetType.


        :param nr_available: The nr_available of this AssetType.
        :type nr_available: int
        """

        self._nr_available = nr_available

    @property
    def assets(self) -> List[Asset]:
        """Gets the assets of this AssetType.


        :return: The assets of this AssetType.
        :rtype: List[Asset]
        """
        return self._assets

    @assets.setter
    def assets(self, assets: List[Asset]):
        """Sets the assets of this AssetType.


        :param assets: The assets of this AssetType.
        :type assets: List[Asset]
        """

        self._assets = assets

    @property
    def asset_class(self) -> AssetClass:
        """Gets the asset_class of this AssetType.


        :return: The asset_class of this AssetType.
        :rtype: AssetClass
        """
        return self._asset_class

    @asset_class.setter
    def asset_class(self, asset_class: AssetClass):
        """Sets the asset_class of this AssetType.


        :param asset_class: The asset_class of this AssetType.
        :type asset_class: AssetClass
        """

        self._asset_class = asset_class

    @property
    def asset_sub_class(self) -> str:
        """Gets the asset_sub_class of this AssetType.

        a more precise classification of the asset, like 'cargo bike', 'public bus', 'coach bus', 'office bus', 'water taxi',  'segway'. This is mandatory when using 'OTHER' as class.  # noqa: E501

        :return: The asset_sub_class of this AssetType.
        :rtype: str
        """
        return self._asset_sub_class

    @asset_sub_class.setter
    def asset_sub_class(self, asset_sub_class: str):
        """Sets the asset_sub_class of this AssetType.

        a more precise classification of the asset, like 'cargo bike', 'public bus', 'coach bus', 'office bus', 'water taxi',  'segway'. This is mandatory when using 'OTHER' as class.  # noqa: E501

        :param asset_sub_class: The asset_sub_class of this AssetType.
        :type asset_sub_class: str
        """

        self._asset_sub_class = asset_sub_class

    @property
    def shared_properties(self) -> AssetProperties:
        """Gets the shared_properties of this AssetType.


        :return: The shared_properties of this AssetType.
        :rtype: AssetProperties
        """
        return self._shared_properties

    @shared_properties.setter
    def shared_properties(self, shared_properties: AssetProperties):
        """Sets the shared_properties of this AssetType.


        :param shared_properties: The shared_properties of this AssetType.
        :type shared_properties: AssetProperties
        """

        self._shared_properties = shared_properties

    @property
    def applicable_pricings(self) -> List[SystemPricingPlan]:
        """Gets the applicable_pricings of this AssetType.

        pricing plans that can be applicable for this assetType. Business logic to determine the final pricing plan is not exposed. Just call the plannings endpoint (v1.2) or the inquiries endpoint (v.1.3)  # noqa: E501

        :return: The applicable_pricings of this AssetType.
        :rtype: List[SystemPricingPlan]
        """
        return self._applicable_pricings

    @applicable_pricings.setter
    def applicable_pricings(self, applicable_pricings: List[SystemPricingPlan]):
        """Sets the applicable_pricings of this AssetType.

        pricing plans that can be applicable for this assetType. Business logic to determine the final pricing plan is not exposed. Just call the plannings endpoint (v1.2) or the inquiries endpoint (v.1.3)  # noqa: E501

        :param applicable_pricings: The applicable_pricings of this AssetType.
        :type applicable_pricings: List[SystemPricingPlan]
        """

        self._applicable_pricings = applicable_pricings

    @property
    def conditions(self) -> List[Condition]:
        """Gets the conditions of this AssetType.

        extra information about the asset type, making it possible to f.x. specifying that booking this car requires a driver license.  # noqa: E501

        :return: The conditions of this AssetType.
        :rtype: List[Condition]
        """
        return self._conditions

    @conditions.setter
    def conditions(self, conditions: List[Condition]):
        """Sets the conditions of this AssetType.

        extra information about the asset type, making it possible to f.x. specifying that booking this car requires a driver license.  # noqa: E501

        :param conditions: The conditions of this AssetType.
        :type conditions: List[Condition]
        """

        self._conditions = conditions