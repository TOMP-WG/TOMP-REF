# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.notification import Notification  # noqa: E501
from swagger_server.test import BaseTestCase


class TestGeneralController(BaseTestCase):
    """GeneralController integration test stubs"""

    def test_bookings_id_notifications_get(self):
        """Test case for bookings_id_notifications_get

        
        """
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/bookings/{id}/notifications'.format(id='id_example'),
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_bookings_id_notifications_post(self):
        """Test case for bookings_id_notifications_post

        
        """
        body = Notification()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/bookings/{id}/notifications'.format(id='id_example'),
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
