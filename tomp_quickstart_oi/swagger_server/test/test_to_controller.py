# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.asset import Asset  # noqa: E501
from swagger_server.models.asset_type import AssetType  # noqa: E501
from swagger_server.models.booking import Booking  # noqa: E501
from swagger_server.models.booking_operation import BookingOperation  # noqa: E501
from swagger_server.models.booking_request import BookingRequest  # noqa: E501
from swagger_server.models.booking_state import BookingState  # noqa: E501
from swagger_server.models.endpoint_implementation import EndpointImplementation  # noqa: E501
from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.journal_entry import JournalEntry  # noqa: E501
from swagger_server.models.journal_state import JournalState  # noqa: E501
from swagger_server.models.leg import Leg  # noqa: E501
from swagger_server.models.leg_event import LegEvent  # noqa: E501
from swagger_server.models.leg_progress import LegProgress  # noqa: E501
from swagger_server.models.notification import Notification  # noqa: E501
from swagger_server.models.planning import Planning  # noqa: E501
from swagger_server.models.planning_request import PlanningRequest  # noqa: E501
from swagger_server.models.station_information import StationInformation  # noqa: E501
from swagger_server.models.support_request import SupportRequest  # noqa: E501
from swagger_server.models.support_status import SupportStatus  # noqa: E501
from swagger_server.models.system_alert import SystemAlert  # noqa: E501
from swagger_server.models.system_calendar import SystemCalendar  # noqa: E501
from swagger_server.models.system_hours import SystemHours  # noqa: E501
from swagger_server.models.system_information import SystemInformation  # noqa: E501
from swagger_server.models.system_pricing_plan import SystemPricingPlan  # noqa: E501
from swagger_server.models.system_region import SystemRegion  # noqa: E501
from swagger_server.test import BaseTestCase


class TestTOController(BaseTestCase):
    """TOController integration test stubs"""

    def test_bookings_get(self):
        """Test case for bookings_get

        
        """
        query_string = [('state', BookingState())]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/bookings',
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

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

    def test_bookings_id_get(self):
        """Test case for bookings_id_get

        
        """
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/bookings/{id}'.format(id='id_example'),
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

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

    def test_bookings_id_put(self):
        """Test case for bookings_id_put

        
        """
        body = Booking()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/bookings/{id}'.format(id='id_example'),
            method='PUT',
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

    def test_planning_inquiries_post(self):
        """Test case for planning_inquiries_post

        
        """
        body = PlanningRequest()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/planning/inquiries',
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_planning_offers_post(self):
        """Test case for planning_offers_post

        
        """
        body = PlanningRequest()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/planning/offers',
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_plannings_post(self):
        """Test case for plannings_post

        
        """
        body = PlanningRequest()
        query_string = [('booking_intent', false)]
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/plannings',
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json',
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_support_id_status_get(self):
        """Test case for support_id_status_get

        
        """
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/support/{id}/status'.format(id='id_example'),
            method='GET',
            headers=headers)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_support_post(self):
        """Test case for support_post

        
        """
        body = SupportRequest()
        headers = [('accept_language', 'accept_language_example'),
                   ('api', 'api_example'),
                   ('api_version', 'api_version_example'),
                   ('maas_id', 'maas_id_example'),
                   ('addressed_to', 'addressed_to_example')]
        response = self.client.open(
            '/support/',
            method='POST',
            data=json.dumps(body),
            headers=headers,
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
