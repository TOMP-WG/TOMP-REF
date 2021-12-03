import connexion
import six

from swagger_server.models.booking import Booking  # noqa: E501
from swagger_server.models.booking_state import BookingState  # noqa: E501
from swagger_server.models.error import Error  # noqa: E501
from swagger_server import util


def bookings_get(accept_language, api, api_version, maas_id, state, addressed_to=None):  # noqa: E501
    """bookings_get

    Optional - Returns bookings that has been created earlier, selected on state. # noqa: E501

    :param accept_language: A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information
    :type accept_language: str
    :param api: API description, can be TOMP or maybe other (specific/derived) API definitions
    :type api: str
    :param api_version: Version of the API.
    :type api_version: str
    :param maas_id: The ID of the sending maas operator
    :type maas_id: str
    :param state: 
    :type state: dict | bytes
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: List[Booking]
    """
    if connexion.request.is_json:
        state = BookingState.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def bookings_id_put(body, accept_language, api, api_version, maas_id, id, addressed_to=None):  # noqa: E501
    """bookings_id_put

    Optional - This endpoint should be used to adjust the parameters of the booking. Changes not acceptable to the TO should return 400. If a booking is started and can no longer be adjusted the TO should return 403. The state of the booking should **never** be adjusted using this method. Use /bookings/{id}/events for that. See also (7.2) in the flow diagram - booking. # noqa: E501

    :param body: changed booking
    :type body: dict | bytes
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

    :rtype: Booking
    """
    if connexion.request.is_json:
        body = Booking.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def bookings_id_subscription_delete(accept_language, api, api_version, maas_id, id, addressed_to=None):  # noqa: E501
    """bookings_id_subscription_delete

    Optional - subscribe to a specific booking (&#x3D;leg &amp; (type of) asset). This is an optional endpoint # noqa: E501

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

    :rtype: None
    """
    return 'do some magic!'


def bookings_id_subscription_post(accept_language, api, api_version, maas_id, id, addressed_to=None):  # noqa: E501
    """bookings_id_subscription_post

    Optional - subscribe to a specific booking (&#x3D;leg &amp; (type of) asset). This is an optional endpoint. This endpoint facilitates notifications in all the phases. (see (7.1) in the flow chart - execution) # noqa: E501

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

    :rtype: None
    """
    return 'do some magic!'
