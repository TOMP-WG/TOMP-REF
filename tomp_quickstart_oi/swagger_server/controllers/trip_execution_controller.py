import connexion
import six

from swagger_server.models.asset import Asset  # noqa: E501
from swagger_server.models.confirmation_request import ConfirmationRequest  # noqa: E501
from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.leg import Leg  # noqa: E501
from swagger_server.models.leg_event import LegEvent  # noqa: E501
from swagger_server.models.leg_progress import LegProgress  # noqa: E501
from swagger_server import util


def legs_id_ancillaries_category_number_delete(accept_language, api, api_version, maas_id, id, category, number, addressed_to=None):  # noqa: E501
    """legs_id_ancillaries_category_number_delete

    an ancillary (or amount) is removed to the leg. # noqa: E501

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
    :param category: ancillary category
    :type category: str
    :param number: ancillary number
    :type number: str
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: Leg
    """
    return 'do some magic!'


def legs_id_ancillaries_category_number_post(accept_language, api, api_version, maas_id, id, category, number, addressed_to=None):  # noqa: E501
    """legs_id_ancillaries_category_number_post

    a new ancillary is added to the leg. # noqa: E501

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
    :param category: ancillary category
    :type category: str
    :param number: ancillary number
    :type number: str
    :param addressed_to: The ID of the maas operator that has to receive this message
    :type addressed_to: str

    :rtype: Leg
    """
    return 'do some magic!'


def legs_id_available_assets_get(accept_language, api, api_version, maas_id, id, addressed_to=None, offset=None, limit=None):  # noqa: E501
    """legs_id_available_assets_get

    Returns a list of available assets for the given leg. These assets can be used to POST to /legs/{id}/asset if no specific asset is assigned by the TO. If picking an asset is not allowed for this booking, or one already has been, 403 should be returned. If the booking is unknown, 404 should be returned. See (4.7) in the process flow. - trip execution # noqa: E501

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
    :param offset: start of the selection
    :type offset: float
    :param limit: count of the selection
    :type limit: float

    :rtype: List[Asset]
    """
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


def legs_id_progress_get(accept_language, api, api_version, maas_id, id, addressed_to=None, location_only=None):  # noqa: E501
    """legs_id_progress_get

    Monitors the current location of the asset and duration &amp; distance of the leg (see (4.7) in process flow) # noqa: E501

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
    :param location_only: Specifies if only the location should be returned
    :type location_only: bool

    :rtype: LegProgress
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
