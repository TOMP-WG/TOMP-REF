# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.asset import Asset  # noqa: E501
from swagger_server.models.confirmation_request import ConfirmationRequest  # noqa: E501
from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.leg import Leg  # noqa: E501
from swagger_server.models.leg_event import LegEvent  # noqa: E501
from swagger_server.models.leg_progress import LegProgress  # noqa: E501
from swagger_server.test import BaseTestCase


class TestTripExecutionController(BaseTestCase):
    """TripExecutionController integration test stubs"""

    def test_legs_id_ancillaries_category_number_delete(self):
        """Test case for legs_id_ancillaries_category_number_delete

        
        """
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/legs/{id}/ancillaries/{category}/{number}'.format(id='id_example', category='category_example', number='number_example'),
            method='DELETE',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_legs_id_ancillaries_category_number_post(self):
        """Test case for legs_id_ancillaries_category_number_post

        
        """
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/legs/{id}/ancillaries/{category}/{number}'.format(id='id_example', category='category_example', number='number_example'),
            method='POST',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_legs_id_available_assets_get(self):
        """Test case for legs_id_available_assets_get

        
        """
        query_string = [('offset', 0),
                        ('limit', 1.2)]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/legs/{id}/available-assets'.format(id='id_example'),
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_legs_id_confirmation_post(self):
        """Test case for legs_id_confirmation_post

        
        """
        body = ConfirmationRequest()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example')]
        response = self.client.open(
            '/legs/{id}/confirmation'.format(id='id_example'),
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_legs_id_events_post(self):
        """Test case for legs_id_events_post

        
        """
        body = LegEvent()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/legs/{id}/events'.format(id='id_example'),
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_legs_id_get(self):
        """Test case for legs_id_get

        
        """
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/legs/{id}'.format(id='id_example'),
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_legs_id_progress_get(self):
        """Test case for legs_id_progress_get

        
        """
        query_string = [('location_only', false)]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/legs/{id}/progress'.format(id='id_example'),
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_legs_id_progress_post(self):
        """Test case for legs_id_progress_post

        
        """
        body = LegProgress()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/legs/{id}/progress'.format(id='id_example'),
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_legs_id_put(self):
        """Test case for legs_id_put

        
        """
        body = Leg()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/legs/{id}'.format(id='id_example'),
            method='PUT',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
