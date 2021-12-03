# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.extra_costs import ExtraCosts  # noqa: E501
from swagger_server.models.journal_entry import JournalEntry  # noqa: E501
from swagger_server.models.journal_state import JournalState  # noqa: E501
from swagger_server.test import BaseTestCase


class TestPaymentController(BaseTestCase):
    """PaymentController integration test stubs"""

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
