import connexion
import six

from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.support_request import SupportRequest  # noqa: E501
from swagger_server.models.support_status import SupportStatus  # noqa: E501
from swagger_server import util


def support_id_status_get(accept_language, api, api_version, maas_id, id, addressed_to=None):  # noqa: E501
    """support_id_status_get

    Gets the status report of the support request. Last status (highest order number) is the current status # noqa: E501

    :param accept_language: A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information
    :type accept_language: str
    :param api: API description, can be TOMP or maybe other (specific/derived) API definitions
    :type api: str
    :param api_version: Version of the API.
    :type api_version: str
    :param maas_id: The ID of the sending maas operator
    :type maas_id: str
    :param id: Booking identifier
    :type id: str
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: List[SupportStatus]
    """
    return 'do some magic!'


def support_post(accept_language, api, api_version, maas_id, body=None, addressed_to=None):  # noqa: E501
    """support_post

    creates a request for support from end user via MP # noqa: E501

    :param accept_language: A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information
    :type accept_language: str
    :param api: API description, can be TOMP or maybe other (specific/derived) API definitions
    :type api: str
    :param api_version: Version of the API.
    :type api_version: str
    :param maas_id: The ID of the sending maas operator
    :type maas_id: str
    :param body: 
    :type body: dict | bytes
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: SupportStatus
    """
    if connexion.request.is_json:
        body = SupportRequest.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'
