# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.endpoint import Endpoint  # noqa: F401,E501
from swagger_server.models.process_identifiers import ProcessIdentifiers  # noqa: F401,E501
from swagger_server.models.scenario import Scenario  # noqa: F401,E501
from swagger_server import util


class EndpointImplementation(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, version: str=None, base_url: str=None, endpoints: List[Endpoint]=None, scenarios: List[Scenario]=None, process_identifiers: ProcessIdentifiers=None):  # noqa: E501
        """EndpointImplementation - a model defined in Swagger

        :param version: The version of this EndpointImplementation.  # noqa: E501
        :type version: str
        :param base_url: The base_url of this EndpointImplementation.  # noqa: E501
        :type base_url: str
        :param endpoints: The endpoints of this EndpointImplementation.  # noqa: E501
        :type endpoints: List[Endpoint]
        :param scenarios: The scenarios of this EndpointImplementation.  # noqa: E501
        :type scenarios: List[Scenario]
        :param process_identifiers: The process_identifiers of this EndpointImplementation.  # noqa: E501
        :type process_identifiers: ProcessIdentifiers
        """
        self.swagger_types = {
            'version': str,
            'base_url': str,
            'endpoints': List[Endpoint],
            'scenarios': List[Scenario],
            'process_identifiers': ProcessIdentifiers
        }

        self.attribute_map = {
            'version': 'version',
            'base_url': 'baseUrl',
            'endpoints': 'endpoints',
            'scenarios': 'scenarios',
            'process_identifiers': 'processIdentifiers'
        }
        self._version = version
        self._base_url = base_url
        self._endpoints = endpoints
        self._scenarios = scenarios
        self._process_identifiers = process_identifiers

    @classmethod
    def from_dict(cls, dikt) -> 'EndpointImplementation':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The endpointImplementation of this EndpointImplementation.  # noqa: E501
        :rtype: EndpointImplementation
        """
        return util.deserialize_model(dikt, cls)

    @property
    def version(self) -> str:
        """Gets the version of this EndpointImplementation.


        :return: The version of this EndpointImplementation.
        :rtype: str
        """
        return self._version

    @version.setter
    def version(self, version: str):
        """Sets the version of this EndpointImplementation.


        :param version: The version of this EndpointImplementation.
        :type version: str
        """
        if version is None:
            raise ValueError("Invalid value for `version`, must not be `None`")  # noqa: E501

        self._version = version

    @property
    def base_url(self) -> str:
        """Gets the base_url of this EndpointImplementation.


        :return: The base_url of this EndpointImplementation.
        :rtype: str
        """
        return self._base_url

    @base_url.setter
    def base_url(self, base_url: str):
        """Sets the base_url of this EndpointImplementation.


        :param base_url: The base_url of this EndpointImplementation.
        :type base_url: str
        """
        if base_url is None:
            raise ValueError("Invalid value for `base_url`, must not be `None`")  # noqa: E501

        self._base_url = base_url

    @property
    def endpoints(self) -> List[Endpoint]:
        """Gets the endpoints of this EndpointImplementation.


        :return: The endpoints of this EndpointImplementation.
        :rtype: List[Endpoint]
        """
        return self._endpoints

    @endpoints.setter
    def endpoints(self, endpoints: List[Endpoint]):
        """Sets the endpoints of this EndpointImplementation.


        :param endpoints: The endpoints of this EndpointImplementation.
        :type endpoints: List[Endpoint]
        """
        if endpoints is None:
            raise ValueError("Invalid value for `endpoints`, must not be `None`")  # noqa: E501

        self._endpoints = endpoints

    @property
    def scenarios(self) -> List[Scenario]:
        """Gets the scenarios of this EndpointImplementation.


        :return: The scenarios of this EndpointImplementation.
        :rtype: List[Scenario]
        """
        return self._scenarios

    @scenarios.setter
    def scenarios(self, scenarios: List[Scenario]):
        """Sets the scenarios of this EndpointImplementation.


        :param scenarios: The scenarios of this EndpointImplementation.
        :type scenarios: List[Scenario]
        """
        if scenarios is None:
            raise ValueError("Invalid value for `scenarios`, must not be `None`")  # noqa: E501

        self._scenarios = scenarios

    @property
    def process_identifiers(self) -> ProcessIdentifiers:
        """Gets the process_identifiers of this EndpointImplementation.


        :return: The process_identifiers of this EndpointImplementation.
        :rtype: ProcessIdentifiers
        """
        return self._process_identifiers

    @process_identifiers.setter
    def process_identifiers(self, process_identifiers: ProcessIdentifiers):
        """Sets the process_identifiers of this EndpointImplementation.


        :param process_identifiers: The process_identifiers of this EndpointImplementation.
        :type process_identifiers: ProcessIdentifiers
        """
        if process_identifiers is None:
            raise ValueError("Invalid value for `process_identifiers`, must not be `None`")  # noqa: E501

        self._process_identifiers = process_identifiers
