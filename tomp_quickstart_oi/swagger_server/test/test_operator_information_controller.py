# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.asset_type import AssetType  # noqa: E501
from swagger_server.models.endpoint_implementation import EndpointImplementation  # noqa: E501
from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.station_information import StationInformation  # noqa: E501
from swagger_server.models.system_alert import SystemAlert  # noqa: E501
from swagger_server.models.system_calendar import SystemCalendar  # noqa: E501
from swagger_server.models.system_hours import SystemHours  # noqa: E501
from swagger_server.models.system_information import SystemInformation  # noqa: E501
from swagger_server.models.system_pricing_plan import SystemPricingPlan  # noqa: E501
from swagger_server.models.system_region import SystemRegion  # noqa: E501
from swagger_server.test import BaseTestCase


class TestOperatorInformationController(BaseTestCase):
    """OperatorInformationController integration test stubs"""

    def test_operator_alerts_get(self):
        """Test case for operator_alerts_get

        informs customers about changes to the system outside of normal operations
        """
        query_string = [('offset', 0),
                        ('limit', 1.2),
                        ('region_id', 'region_id_example'),
                        ('station_id', 'station_id_example')]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/operator/alerts',
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_operator_available_assets_get(self):
        """Test case for operator_available_assets_get

        
        """
        query_string = [('offset', 0),
                        ('limit', 1.2),
                        ('region_id', 'region_id_example'),
                        ('station_id', 'station_id_example')]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/operator/available-assets',
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_operator_information_get(self):
        """Test case for operator_information_get

        describes the system
        """
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/operator/information',
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_operator_meta_get(self):
        """Test case for operator_meta_get

        describes the running implementations
        """
        headers = [('accept_language', 'accept_language_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/operator/meta',
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_operator_operating_calendar_get(self):
        """Test case for operator_operating_calendar_get

        describes the operating calendar for a system. An array of year objects defined as follows (if start/end year are omitted, then assume the start and end months do not change from year to year). [from GFBS]
        """
        query_string = [('region_id', 'region_id_example'),
                        ('station_id', 'station_id_example')]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/operator/operating-calendar',
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_operator_operating_hours_get(self):
        """Test case for operator_operating_hours_get

        describes the system hours of operation
        """
        query_string = [('region_id', 'region_id_example'),
                        ('station_id', 'station_id_example')]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/operator/operating-hours',
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_operator_ping_get(self):
        """Test case for operator_ping_get

        Describes the status of the Transport Operator - whether the APIs are running or not
        """
        headers = [('accept_language', 'accept_language_example')]
        response = self.client.open(
            '/operator/ping',
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_operator_pricing_plans_get(self):
        """Test case for operator_pricing_plans_get

        gives pricing information
        """
        query_string = [('region_id', 'region_id_example'),
                        ('station_id', 'station_id_example')]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/operator/pricing-plans',
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_operator_regions_get(self):
        """Test case for operator_regions_get

        describes regions for a system that is broken up by geographic or political region. It is defined as a separate feed to allow for additional region metadata (such as shape definitions). [from GBFS]
        """
        query_string = [('offset', 0),
                        ('limit', 1.2)]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/operator/regions',
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_operator_stations_get(self):
        """Test case for operator_stations_get

        describes all available stations
        """
        query_string = [('offset', 0),
                        ('limit', 1.2),
                        ('region_id', 'region_id_example'),
                        ('lon', 1.2),
                        ('lat', 1.2),
                        ('radius', 1.2)]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/operator/stations',
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
