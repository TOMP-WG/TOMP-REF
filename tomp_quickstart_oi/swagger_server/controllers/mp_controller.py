import connexion
import six

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


def legs_id_confirmation_post(accept_language, api, api_version, id, body=None):  # noqa: E501
    """legs_id_confirmation_post

    The TO can request confirmation for certain actions from the MP. # noqa: E501

    :param accept_language: A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information
    :type accept_language: str
    :param api: API description, can be TOMP or maybe other (specific/derived) API definitions
    :type api: str
    :param api_version: Version of the API.
    :type api_version: str
    :param id: Leg identifier
    :type id: str
    :param body: 
    :type body: dict | bytes

    :rtype: bool
    """
    if connexion.request.is_json:
        body = ConfirmationRequest.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def legs_id_events_post(accept_language, api, api_version, maas_id, id, body=None, addressed_to=None):  # noqa: E501
    """legs_id_events_post

    This endpoint must be used to alter the state of a leg.&lt;br&gt; Operations:&lt;br&gt; &#x60;PREPARE&#x60; the TO can send a message telling the MP that he is preparing the booked leg [To be implemented by the MP] (see (7.2) in the process flow - trip execution),&lt;br&gt; &#x60;ASSIGN_ASSET&#x60; can assign an asset to a leg. Can be to assign an asset in case there is still an asset type assigned [Optionally implementable by the MP]. See (4.7) in the process flow - trip execution&lt;br&gt; &#x60;SET_IN_USE&#x60; will activate the leg or resume the leg [TO and MP] (see (4.6) in process flow),&lt;br&gt; &#x60;TIME_EXTEND&#x60; will be used to request an extension in time; the end user wants to use the asset longer, the &#x60;time&#x60; field contains the new end time,&lt;br&gt; &#x60;TIME_POSTPONE&#x60; will be used to request a delay in the departure time, the end user wants to depart later, the &#x60;time&#x60; field contains the new departure time,&lt;br&gt; &#x60;PAUSE&#x60; will pause the leg [TO and MP] (see (4.6) in process flow),&lt;br&gt; &#x60;START_FINISHING&#x60; will start the end-of-leg [Optionally implementable by TO and MP],&lt;br&gt; &#x60;FINISH&#x60; will end this leg (see (4.6) in process flow) [TO and MP] # noqa: E501

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

    :rtype: Leg
    """
    if connexion.request.is_json:
        body = LegEvent.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def legs_id_get(accept_language, api, api_version, maas_id, id, addressed_to=None):  # noqa: E501
    """legs_id_get

    Retrieves the latest summary of the leg, being the execution of a portion of a journey travelled using one asset (vehicle). Every leg belongs to one booking, every booking has at least one leg. Where the booking describes the agreement between user/MP and TO, the leg describes the journey as it occured. See (4.3) in the flow chart - trip execution # noqa: E501

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
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: Leg
    """
    return 'do some magic!'


def legs_id_progress_post(accept_language, api, api_version, maas_id, id, body=None, addressed_to=None):  # noqa: E501
    """legs_id_progress_post

    Monitors the current location of the asset and duration &amp; distance of the leg # noqa: E501

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

    :rtype: None
    """
    if connexion.request.is_json:
        body = LegProgress.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def legs_id_put(body, accept_language, api, api_version, maas_id, id, addressed_to=None):  # noqa: E501
    """legs_id_put

    Updates the leg with new information. Only used for updates about execution to the MP. To request changes as the MP, the booking should be updated and the TO can accept the change and update the leg in turn. # noqa: E501

    :param body: changed leg (e.g. with different duration or destination)
    :type body: dict | bytes
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
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: None
    """
    if connexion.request.is_json:
        body = Leg.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def operator_meta_get(accept_language, maas_id, addressed_to=None):  # noqa: E501
    """describes the running implementations

    all versions that are implemented on this url, are described in the result of this endpoint. In contains all versions and per version the endpoints, their status and the supported scenarios. # noqa: E501

    :param accept_language: A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information
    :type accept_language: str
    :param maas_id: The ID of the sending maas operator
    :type maas_id: str
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: List[EndpointImplementation]
    """
    return 'do some magic!'


def operator_ping_get(accept_language):  # noqa: E501
    """Describes the status of the Transport Operator - whether the APIs are running or not

    This is a healthcheck endpoint to see if the TO is up and running perfectly. # noqa: E501

    :param accept_language: A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information
    :type accept_language: str

    :rtype: None
    """
    return 'do some magic!'


def payment_id_claim_extra_costs_post(accept_language, api, api_version, maas_id, id, body=None, addressed_to=None):  # noqa: E501
    """payment_id_claim_extra_costs_post

    extra costs that the TO has to charge to the MP or vice versa. # noqa: E501

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

    :rtype: JournalEntry
    """
    if connexion.request.is_json:
        body = ExtraCosts.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def payment_journal_entry_get(accept_language, api, api_version, maas_id, addressed_to=None, _from=None, to=None, state=None, id=None, category=None, offset=None, limit=None):  # noqa: E501
    """payment_journal_entry_get

    Returns all the journal entries that should be paid per leg # noqa: E501

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
    :param _from: start of the selection
    :type _from: str
    :param to: end of the selection
    :type to: str
    :param state: 
    :type state: dict | bytes
    :param id: 
    :type id: str
    :param category: type of booking line (e.g. fare, addition costs, fines, ...)
    :type category: str
    :param offset: start of the selection
    :type offset: float
    :param limit: count of the selection
    :type limit: float

    :rtype: List[JournalEntry]
    """
    _from = util.deserialize_datetime(_from)
    to = util.deserialize_datetime(to)
    if connexion.request.is_json:
        state = JournalState.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'
