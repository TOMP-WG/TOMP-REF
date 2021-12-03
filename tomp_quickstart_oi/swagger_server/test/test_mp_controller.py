# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.booking import Booking  # noqa: E501
from swagger_server.models.booking_operation import BookingOperation  # noqa: E501
from swagger_server.models.booking_request import BookingRequest  # noqa: E501
from swagger_server.models.confirmation_request import ConfirmationRequest  # noqa: E501
from swagger_server.models.endpoint_implementation import EndpointImplementation  # noqa: E501
from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.extra_costs import ExtraCosts  # noqa: E501
from swagger_server.models.journal_entry import JournalEntry  # noqa: E501
from swagger_server.models.journal_state import JournalState  # noqa: E501
from swagger_server.models.leg import Leg  # noqa: E501
from swagger_server.models.leg_event import LegEvent  # noqa: E501
from swagger_server.models.leg_progress import LegProgress  # noqa: E501
from swagger_server.models.notification import Notification  # noqa: E501
from swagger_server.test import BaseTestCase


class TestMPController(BaseTestCase):
    """MPController integration test stubs"""

    def test_bookings_id_events_post(self):
        """Test case for bookings_id_events_post

        
        """
        body = BookingOperation()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/bookings/{id}/events'.format(id='id_example'),
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
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

    def test_bookings_id_subscription_delete(self):
        """Test case for bookings_id_subscription_delete

        
        """
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/bookings/{id}/subscription'.format(id='id_example'),
            method='DELETE',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_bookings_id_subscription_post(self):
        """Test case for bookings_id_subscription_post

        
        """
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/bookings/{id}/subscription'.format(id='id_example'),
            method='POST',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_bookings_post(self):
        """Test case for bookings_post

        
        """
        body = BookingRequest()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/bookings',
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
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

    def test_payment_id_claim_extra_costs_post(self):
        """Test case for payment_id_claim_extra_costs_post

        
        """
        body = ExtraCosts()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/payment/{id}/claim-extra-costs'.format(id='id_example'),
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_payment_journal_entry_get(self):
        """Test case for payment_journal_entry_get

        
        """
        query_string = [('_from', '2013-10-20T19:20:30+01:00'),
                        ('to', '2013-10-20T19:20:30+01:00'),
                        ('state', JournalState()),
                        ('id', 'id_example'),
                        ('category', 'category_example'),
                        ('offset', 0),
                        ('limit', 1.2)]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/payment/journal-entry',
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
