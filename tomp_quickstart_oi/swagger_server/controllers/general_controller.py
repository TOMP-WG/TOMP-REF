import connexion
import six

from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.notification import Notification  # noqa: E501
from swagger_server import util


def bookings_id_notifications_get(accept_language, api, api_version, maas_id, id, addressed_to=None):  # noqa: E501
    """bookings_id_notifications_get

    retrieves all notifications concerning events related to this booking. # noqa: E501

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

    :rtype: List[Notification]
    """
    return 'do some magic!'


def bookings_id_notifications_post(accept_language, api, api_version, maas_id, id, body=None, addressed_to=None):  # noqa: E501
    """bookings_id_notifications_post

    notification between MaaS provider and Transport operator in case of user no-show or if specific asset is not available or some other event occurs not covered by other API calls. # noqa: E501

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
    :param body: 
    :type body: dict | bytes
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: None
    """
    if connexion.request.is_json:
        body = Notification.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'
