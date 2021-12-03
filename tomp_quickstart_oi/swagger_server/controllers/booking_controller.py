import connexion
import six

from swagger_server.models.booking import Booking  # noqa: E501
from swagger_server.models.booking_operation import BookingOperation  # noqa: E501
from swagger_server.models.booking_request import BookingRequest  # noqa: E501
from swagger_server.models.error import Error  # noqa: E501
from swagger_server import util


def bookings_id_events_post(accept_language, api, api_version, maas_id, id, body=None, addressed_to=None):  # noqa: E501
    """bookings_id_events_post

    This endpoint **must** be used to alter the state of a booking:&lt;br&gt;- The operation &#x27;CANCEL&#x27; Cancels the booking (see &lt;4&gt; in the process flow - booking), &lt;br&gt;- the operation &#x27;EXPIRE&#x27; informs that the booking-option is expired (see &lt;5&gt; in the process flow - booking) and &lt;br&gt;- the &#x27;COMMIT&#x27; actually makes this booking option a real confirmed booking. (see also (3.2) in process flow - booking). This event should also be used to commit in the &#x27;postponed-commit&#x27; scenario.&lt;br&gt; - &#x27;DENY&#x27; tells the MP that the leg is cancelled in the post-commit scenario. &lt;p&gt; &#x60;CANCEL&#x60; - Cancels a confirmed booking. Cancelling twice should still return 204. &lt;br&gt; &#x60;EXPIRE&#x60; - Typically for sending back a signal from TO to MP to tell the pending state is expired. Expiring twice should return 204. Expiring a booking in a non-pending state will result in 403. &lt;BR&gt; &#x60;COMMIT&#x60; - Turns the booking in a confirmed state, after all legs are in state pending. Committing twice will result in 204. If the booking is in state CANCELLED or EXPIRED, a commit will result a 403. &lt;BR&gt; &#x60;DENY&#x60; - Used for the &#x27;postponed-commit&#x27; scenario. Whenever a TO cannot give guarantees directly to fulfil a booking, it can return a &#x27;COMMIT&#x27;, but the state of the booking object should be &#x27;POSTPONED-COMMIT&#x27;. In the conditions returned in the planning phase is stated until when this phase can be. After this time it will become expired. Otherwise, it can be committed when the leg is confirmed or denied (using this event). # noqa: E501

    :param accept_language: A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information
    :type accept_language: str
    :param api: API description, can be TOMP or maybe other (specific/derived) API definitions
    :type api: str
    :param api_version: Version of the API.
    :type api_version: str
    :param maas_id: The ID of the sending maas operator
    :type maas_id: str
    :param id: Leg identifier
    :type id: str
    :param body: 
    :type body: dict | bytes
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: Booking
    """
    if connexion.request.is_json:
        body = BookingOperation.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def bookings_id_get(accept_language, api, api_version, maas_id, id, addressed_to=None):  # noqa: E501
    """bookings_id_get

    Returns the booking. See (3.5.2) in the process flow - booking. In the &#x27;meta&#x27;-field the digital tickes can be returned (see (3.3) in the process flow - booking) # noqa: E501

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
    return 'do some magic!'


def bookings_post(body, accept_language, api, api_version, maas_id, addressed_to=None):  # noqa: E501
    """bookings_post

    Creates a new &#x60;Booking&#x60; for the TO in **Pending** state. The ID of the posted booking should be the ID provided in the previous step (planning). &lt;p&gt;The Booking may be modified in the response, e.g. location being adjusted for a more suitable pick-up location. In addition, the service may contain a **meta** attribute for arbitrary TO metadata that the TO needs later, and **token** attribute depicting how long the current state is valid. &lt;p&gt; see (3.2) in the process flow - booking. &lt;p&gt;The MP can implement this endpoint when it allows direct booking by TOs. The specific TO can book an asset from themselves to get it registrated and handled (financially) by the MP. # noqa: E501

    :param body: One of available booking options, returned by /plannings, with an ID.
    :type body: dict | bytes
    :param accept_language: A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information
    :type accept_language: str
    :param api: API description, can be TOMP or maybe other (specific/derived) API definitions
    :type api: str
    :param api_version: Version of the API.
    :type api_version: str
    :param maas_id: The ID of the sending maas operator
    :type maas_id: str
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: Booking
    """
    if connexion.request.is_json:
        body = BookingRequest.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'
