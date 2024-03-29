# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.asset_class import AssetClass  # noqa: F401,E501
from swagger_server.models.chamber_of_commerce_info import ChamberOfCommerceInfo  # noqa: F401,E501
from swagger_server import util


class SystemInformation(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, system_id: str=None, language: List[str]=None, name: str=None, short_name: str=None, operator: str=None, url: str=None, purchase_url: str=None, discovery_uri_android: str=None, discovery_uri_ios: str=None, store_uri_android: str=None, store_uri_ios: str=None, start_date: date=None, phone_number: str=None, email: str=None, feed_contact_email: str=None, timezone: str=None, license_url: str=None, type_of_system: str=None, chamber_of_commerce_info: ChamberOfCommerceInfo=None, conditions: str=None, product_type: str=None, asset_classes: List[AssetClass]=None):  # noqa: E501
        """SystemInformation - a model defined in Swagger

        :param system_id: The system_id of this SystemInformation.  # noqa: E501
        :type system_id: str
        :param language: The language of this SystemInformation.  # noqa: E501
        :type language: List[str]
        :param name: The name of this SystemInformation.  # noqa: E501
        :type name: str
        :param short_name: The short_name of this SystemInformation.  # noqa: E501
        :type short_name: str
        :param operator: The operator of this SystemInformation.  # noqa: E501
        :type operator: str
        :param url: The url of this SystemInformation.  # noqa: E501
        :type url: str
        :param purchase_url: The purchase_url of this SystemInformation.  # noqa: E501
        :type purchase_url: str
        :param discovery_uri_android: The discovery_uri_android of this SystemInformation.  # noqa: E501
        :type discovery_uri_android: str
        :param discovery_uri_ios: The discovery_uri_ios of this SystemInformation.  # noqa: E501
        :type discovery_uri_ios: str
        :param store_uri_android: The store_uri_android of this SystemInformation.  # noqa: E501
        :type store_uri_android: str
        :param store_uri_ios: The store_uri_ios of this SystemInformation.  # noqa: E501
        :type store_uri_ios: str
        :param start_date: The start_date of this SystemInformation.  # noqa: E501
        :type start_date: date
        :param phone_number: The phone_number of this SystemInformation.  # noqa: E501
        :type phone_number: str
        :param email: The email of this SystemInformation.  # noqa: E501
        :type email: str
        :param feed_contact_email: The feed_contact_email of this SystemInformation.  # noqa: E501
        :type feed_contact_email: str
        :param timezone: The timezone of this SystemInformation.  # noqa: E501
        :type timezone: str
        :param license_url: The license_url of this SystemInformation.  # noqa: E501
        :type license_url: str
        :param type_of_system: The type_of_system of this SystemInformation.  # noqa: E501
        :type type_of_system: str
        :param chamber_of_commerce_info: The chamber_of_commerce_info of this SystemInformation.  # noqa: E501
        :type chamber_of_commerce_info: ChamberOfCommerceInfo
        :param conditions: The conditions of this SystemInformation.  # noqa: E501
        :type conditions: str
        :param product_type: The product_type of this SystemInformation.  # noqa: E501
        :type product_type: str
        :param asset_classes: The asset_classes of this SystemInformation.  # noqa: E501
        :type asset_classes: List[AssetClass]
        """
        self.swagger_types = {
            'system_id': str,
            'language': List[str],
            'name': str,
            'short_name': str,
            'operator': str,
            'url': str,
            'purchase_url': str,
            'discovery_uri_android': str,
            'discovery_uri_ios': str,
            'store_uri_android': str,
            'store_uri_ios': str,
            'start_date': date,
            'phone_number': str,
            'email': str,
            'feed_contact_email': str,
            'timezone': str,
            'license_url': str,
            'type_of_system': str,
            'chamber_of_commerce_info': ChamberOfCommerceInfo,
            'conditions': str,
            'product_type': str,
            'asset_classes': List[AssetClass]
        }

        self.attribute_map = {
            'system_id': 'systemId',
            'language': 'language',
            'name': 'name',
            'short_name': 'shortName',
            'operator': 'operator',
            'url': 'url',
            'purchase_url': 'purchaseUrl',
            'discovery_uri_android': 'discoveryUriAndroid',
            'discovery_uri_ios': 'discoveryUriIOS',
            'store_uri_android': 'storeUriAndroid',
            'store_uri_ios': 'storeUriIOS',
            'start_date': 'startDate',
            'phone_number': 'phoneNumber',
            'email': 'email',
            'feed_contact_email': 'feedContactEmail',
            'timezone': 'timezone',
            'license_url': 'licenseUrl',
            'type_of_system': 'typeOfSystem',
            'chamber_of_commerce_info': 'chamberOfCommerceInfo',
            'conditions': 'conditions',
            'product_type': 'productType',
            'asset_classes': 'assetClasses'
        }
        self._system_id = system_id
        self._language = language
        self._name = name
        self._short_name = short_name
        self._operator = operator
        self._url = url
        self._purchase_url = purchase_url
        self._discovery_uri_android = discovery_uri_android
        self._discovery_uri_ios = discovery_uri_ios
        self._store_uri_android = store_uri_android
        self._store_uri_ios = store_uri_ios
        self._start_date = start_date
        self._phone_number = phone_number
        self._email = email
        self._feed_contact_email = feed_contact_email
        self._timezone = timezone
        self._license_url = license_url
        self._type_of_system = type_of_system
        self._chamber_of_commerce_info = chamber_of_commerce_info
        self._conditions = conditions
        self._product_type = product_type
        self._asset_classes = asset_classes

    @classmethod
    def from_dict(cls, dikt) -> 'SystemInformation':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The systemInformation of this SystemInformation.  # noqa: E501
        :rtype: SystemInformation
        """
        return util.deserialize_model(dikt, cls)

    @property
    def system_id(self) -> str:
        """Gets the system_id of this SystemInformation.

        identifier for this transport system. This should be globally unique (even between different systems)  # noqa: E501

        :return: The system_id of this SystemInformation.
        :rtype: str
        """
        return self._system_id

    @system_id.setter
    def system_id(self, system_id: str):
        """Sets the system_id of this SystemInformation.

        identifier for this transport system. This should be globally unique (even between different systems)  # noqa: E501

        :param system_id: The system_id of this SystemInformation.
        :type system_id: str
        """
        if system_id is None:
            raise ValueError("Invalid value for `system_id`, must not be `None`")  # noqa: E501

        self._system_id = system_id

    @property
    def language(self) -> List[str]:
        """Gets the language of this SystemInformation.

        The languages supported by this operator for user-facing text. These can be requested using the Accept-Language header and should then be returned in Content-Language  # noqa: E501

        :return: The language of this SystemInformation.
        :rtype: List[str]
        """
        return self._language

    @language.setter
    def language(self, language: List[str]):
        """Sets the language of this SystemInformation.

        The languages supported by this operator for user-facing text. These can be requested using the Accept-Language header and should then be returned in Content-Language  # noqa: E501

        :param language: The language of this SystemInformation.
        :type language: List[str]
        """
        if language is None:
            raise ValueError("Invalid value for `language`, must not be `None`")  # noqa: E501

        self._language = language

    @property
    def name(self) -> str:
        """Gets the name of this SystemInformation.

        Full name of the system to be displayed to customers, could match Content-Language  # noqa: E501

        :return: The name of this SystemInformation.
        :rtype: str
        """
        return self._name

    @name.setter
    def name(self, name: str):
        """Sets the name of this SystemInformation.

        Full name of the system to be displayed to customers, could match Content-Language  # noqa: E501

        :param name: The name of this SystemInformation.
        :type name: str
        """
        if name is None:
            raise ValueError("Invalid value for `name`, must not be `None`")  # noqa: E501

        self._name = name

    @property
    def short_name(self) -> str:
        """Gets the short_name of this SystemInformation.

        Optional abbreviation for a system  # noqa: E501

        :return: The short_name of this SystemInformation.
        :rtype: str
        """
        return self._short_name

    @short_name.setter
    def short_name(self, short_name: str):
        """Sets the short_name of this SystemInformation.

        Optional abbreviation for a system  # noqa: E501

        :param short_name: The short_name of this SystemInformation.
        :type short_name: str
        """

        self._short_name = short_name

    @property
    def operator(self) -> str:
        """Gets the operator of this SystemInformation.

        Name of the operator of the system, could match Content-Language  # noqa: E501

        :return: The operator of this SystemInformation.
        :rtype: str
        """
        return self._operator

    @operator.setter
    def operator(self, operator: str):
        """Sets the operator of this SystemInformation.

        Name of the operator of the system, could match Content-Language  # noqa: E501

        :param operator: The operator of this SystemInformation.
        :type operator: str
        """

        self._operator = operator

    @property
    def url(self) -> str:
        """Gets the url of this SystemInformation.

        The URL of the transport operator. The value must be a fully qualified URL that includes http:// or https://, and any special characters in the URL must be correctly escaped.  # noqa: E501

        :return: The url of this SystemInformation.
        :rtype: str
        """
        return self._url

    @url.setter
    def url(self, url: str):
        """Sets the url of this SystemInformation.

        The URL of the transport operator. The value must be a fully qualified URL that includes http:// or https://, and any special characters in the URL must be correctly escaped.  # noqa: E501

        :param url: The url of this SystemInformation.
        :type url: str
        """

        self._url = url

    @property
    def purchase_url(self) -> str:
        """Gets the purchase_url of this SystemInformation.

        A fully qualified URL where a customer can purchase a membership or learn more about purchasing memberships  # noqa: E501

        :return: The purchase_url of this SystemInformation.
        :rtype: str
        """
        return self._purchase_url

    @purchase_url.setter
    def purchase_url(self, purchase_url: str):
        """Sets the purchase_url of this SystemInformation.

        A fully qualified URL where a customer can purchase a membership or learn more about purchasing memberships  # noqa: E501

        :param purchase_url: The purchase_url of this SystemInformation.
        :type purchase_url: str
        """

        self._purchase_url = purchase_url

    @property
    def discovery_uri_android(self) -> str:
        """Gets the discovery_uri_android of this SystemInformation.

        Uri to detect if the app is available at the mobile.  # noqa: E501

        :return: The discovery_uri_android of this SystemInformation.
        :rtype: str
        """
        return self._discovery_uri_android

    @discovery_uri_android.setter
    def discovery_uri_android(self, discovery_uri_android: str):
        """Sets the discovery_uri_android of this SystemInformation.

        Uri to detect if the app is available at the mobile.  # noqa: E501

        :param discovery_uri_android: The discovery_uri_android of this SystemInformation.
        :type discovery_uri_android: str
        """

        self._discovery_uri_android = discovery_uri_android

    @property
    def discovery_uri_ios(self) -> str:
        """Gets the discovery_uri_ios of this SystemInformation.

        Uri to detect if the app is available at the mobile.  # noqa: E501

        :return: The discovery_uri_ios of this SystemInformation.
        :rtype: str
        """
        return self._discovery_uri_ios

    @discovery_uri_ios.setter
    def discovery_uri_ios(self, discovery_uri_ios: str):
        """Sets the discovery_uri_ios of this SystemInformation.

        Uri to detect if the app is available at the mobile.  # noqa: E501

        :param discovery_uri_ios: The discovery_uri_ios of this SystemInformation.
        :type discovery_uri_ios: str
        """

        self._discovery_uri_ios = discovery_uri_ios

    @property
    def store_uri_android(self) -> str:
        """Gets the store_uri_android of this SystemInformation.

        Uri to the app in the store.  # noqa: E501

        :return: The store_uri_android of this SystemInformation.
        :rtype: str
        """
        return self._store_uri_android

    @store_uri_android.setter
    def store_uri_android(self, store_uri_android: str):
        """Sets the store_uri_android of this SystemInformation.

        Uri to the app in the store.  # noqa: E501

        :param store_uri_android: The store_uri_android of this SystemInformation.
        :type store_uri_android: str
        """

        self._store_uri_android = store_uri_android

    @property
    def store_uri_ios(self) -> str:
        """Gets the store_uri_ios of this SystemInformation.

        Uri to the app in the store.  # noqa: E501

        :return: The store_uri_ios of this SystemInformation.
        :rtype: str
        """
        return self._store_uri_ios

    @store_uri_ios.setter
    def store_uri_ios(self, store_uri_ios: str):
        """Sets the store_uri_ios of this SystemInformation.

        Uri to the app in the store.  # noqa: E501

        :param store_uri_ios: The store_uri_ios of this SystemInformation.
        :type store_uri_ios: str
        """

        self._store_uri_ios = store_uri_ios

    @property
    def start_date(self) -> date:
        """Gets the start_date of this SystemInformation.


        :return: The start_date of this SystemInformation.
        :rtype: date
        """
        return self._start_date

    @start_date.setter
    def start_date(self, start_date: date):
        """Sets the start_date of this SystemInformation.


        :param start_date: The start_date of this SystemInformation.
        :type start_date: date
        """

        self._start_date = start_date

    @property
    def phone_number(self) -> str:
        """Gets the phone_number of this SystemInformation.

        A single voice telephone number for the specified system. This field is a string value that presents the telephone number as typical for the system's service area. It can and should contain punctuation marks to group the digits of the number.  # noqa: E501

        :return: The phone_number of this SystemInformation.
        :rtype: str
        """
        return self._phone_number

    @phone_number.setter
    def phone_number(self, phone_number: str):
        """Sets the phone_number of this SystemInformation.

        A single voice telephone number for the specified system. This field is a string value that presents the telephone number as typical for the system's service area. It can and should contain punctuation marks to group the digits of the number.  # noqa: E501

        :param phone_number: The phone_number of this SystemInformation.
        :type phone_number: str
        """

        self._phone_number = phone_number

    @property
    def email(self) -> str:
        """Gets the email of this SystemInformation.

        A single contact email address for customers to address questions about the system  # noqa: E501

        :return: The email of this SystemInformation.
        :rtype: str
        """
        return self._email

    @email.setter
    def email(self, email: str):
        """Sets the email of this SystemInformation.

        A single contact email address for customers to address questions about the system  # noqa: E501

        :param email: The email of this SystemInformation.
        :type email: str
        """

        self._email = email

    @property
    def feed_contact_email(self) -> str:
        """Gets the feed_contact_email of this SystemInformation.

        A single contact email address for consumers of this feed to report technical issues.  # noqa: E501

        :return: The feed_contact_email of this SystemInformation.
        :rtype: str
        """
        return self._feed_contact_email

    @feed_contact_email.setter
    def feed_contact_email(self, feed_contact_email: str):
        """Sets the feed_contact_email of this SystemInformation.

        A single contact email address for consumers of this feed to report technical issues.  # noqa: E501

        :param feed_contact_email: The feed_contact_email of this SystemInformation.
        :type feed_contact_email: str
        """

        self._feed_contact_email = feed_contact_email

    @property
    def timezone(self) -> str:
        """Gets the timezone of this SystemInformation.

        The time zone where the system is located. Time zone names never contain the space character but may contain an underscore. Please refer to the \"TZ\" value in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones for a list of valid values  # noqa: E501

        :return: The timezone of this SystemInformation.
        :rtype: str
        """
        return self._timezone

    @timezone.setter
    def timezone(self, timezone: str):
        """Sets the timezone of this SystemInformation.

        The time zone where the system is located. Time zone names never contain the space character but may contain an underscore. Please refer to the \"TZ\" value in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones for a list of valid values  # noqa: E501

        :param timezone: The timezone of this SystemInformation.
        :type timezone: str
        """
        if timezone is None:
            raise ValueError("Invalid value for `timezone`, must not be `None`")  # noqa: E501

        self._timezone = timezone

    @property
    def license_url(self) -> str:
        """Gets the license_url of this SystemInformation.

        A fully qualified URL of a page that defines the license terms for the GBFS data for this system, as well as any other license terms the system would like to define (including the use of corporate trademarks, etc)  # noqa: E501

        :return: The license_url of this SystemInformation.
        :rtype: str
        """
        return self._license_url

    @license_url.setter
    def license_url(self, license_url: str):
        """Sets the license_url of this SystemInformation.

        A fully qualified URL of a page that defines the license terms for the GBFS data for this system, as well as any other license terms the system would like to define (including the use of corporate trademarks, etc)  # noqa: E501

        :param license_url: The license_url of this SystemInformation.
        :type license_url: str
        """

        self._license_url = license_url

    @property
    def type_of_system(self) -> str:
        """Gets the type_of_system of this SystemInformation.

        Describes the type of system  # noqa: E501

        :return: The type_of_system of this SystemInformation.
        :rtype: str
        """
        return self._type_of_system

    @type_of_system.setter
    def type_of_system(self, type_of_system: str):
        """Sets the type_of_system of this SystemInformation.

        Describes the type of system  # noqa: E501

        :param type_of_system: The type_of_system of this SystemInformation.
        :type type_of_system: str
        """
        allowed_values = ["FREE_FLOATING", "STATION_BASED", "VIRTUAL_STATION_BASED"]  # noqa: E501
        if type_of_system not in allowed_values:
            raise ValueError(
                "Invalid value for `type_of_system` ({0}), must be one of {1}"
                .format(type_of_system, allowed_values)
            )

        self._type_of_system = type_of_system

    @property
    def chamber_of_commerce_info(self) -> ChamberOfCommerceInfo:
        """Gets the chamber_of_commerce_info of this SystemInformation.


        :return: The chamber_of_commerce_info of this SystemInformation.
        :rtype: ChamberOfCommerceInfo
        """
        return self._chamber_of_commerce_info

    @chamber_of_commerce_info.setter
    def chamber_of_commerce_info(self, chamber_of_commerce_info: ChamberOfCommerceInfo):
        """Sets the chamber_of_commerce_info of this SystemInformation.


        :param chamber_of_commerce_info: The chamber_of_commerce_info of this SystemInformation.
        :type chamber_of_commerce_info: ChamberOfCommerceInfo
        """

        self._chamber_of_commerce_info = chamber_of_commerce_info

    @property
    def conditions(self) -> str:
        """Gets the conditions of this SystemInformation.

        Added to include possibility to communicatie general rental conditions like minimum age, max. reservation time etc. [amended]  # noqa: E501

        :return: The conditions of this SystemInformation.
        :rtype: str
        """
        return self._conditions

    @conditions.setter
    def conditions(self, conditions: str):
        """Sets the conditions of this SystemInformation.

        Added to include possibility to communicatie general rental conditions like minimum age, max. reservation time etc. [amended]  # noqa: E501

        :param conditions: The conditions of this SystemInformation.
        :type conditions: str
        """

        self._conditions = conditions

    @property
    def product_type(self) -> str:
        """Gets the product_type of this SystemInformation.

        the type of product offered. SHARING should also be used for public transport.  # noqa: E501

        :return: The product_type of this SystemInformation.
        :rtype: str
        """
        return self._product_type

    @product_type.setter
    def product_type(self, product_type: str):
        """Sets the product_type of this SystemInformation.

        the type of product offered. SHARING should also be used for public transport.  # noqa: E501

        :param product_type: The product_type of this SystemInformation.
        :type product_type: str
        """
        allowed_values = ["RENTAL", "SHARING", "PARKING", "CHARGING"]  # noqa: E501
        if product_type not in allowed_values:
            raise ValueError(
                "Invalid value for `product_type` ({0}), must be one of {1}"
                .format(product_type, allowed_values)
            )

        self._product_type = product_type

    @property
    def asset_classes(self) -> List[AssetClass]:
        """Gets the asset_classes of this SystemInformation.


        :return: The asset_classes of this SystemInformation.
        :rtype: List[AssetClass]
        """
        return self._asset_classes

    @asset_classes.setter
    def asset_classes(self, asset_classes: List[AssetClass]):
        """Sets the asset_classes of this SystemInformation.


        :param asset_classes: The asset_classes of this SystemInformation.
        :type asset_classes: List[AssetClass]
        """

        self._asset_classes = asset_classes
