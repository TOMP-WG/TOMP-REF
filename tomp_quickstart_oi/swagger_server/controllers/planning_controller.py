import connexion
import six

from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.planning import Planning  # noqa: E501
from swagger_server.models.planning_request import PlanningRequest  # noqa: E501
from swagger_server import util


def planning_inquiries_post(accept_language, api, api_version, maas_id, body=None, addressed_to=None):  # noqa: E501
    """planning_inquiries_post

    Returns informative options for the given travel plan. &lt;p&gt;Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of \&quot;Date.now()\&quot; is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. &lt;p&gt;In the final check, just before presenting the alternatives to the user, a call should be made using &#x60;booking-intent&#x60;, requesting the TO to provide booking IDs to reference to during communication with the MP. &lt;p&gt;see (2.1) in the process flow - planning. # noqa: E501

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

    :rtype: Planning
    """
    if connexion.request.is_json:
        body = PlanningRequest.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def planning_offers_post(accept_language, api, api_version, maas_id, body=None, addressed_to=None):  # noqa: E501
    """planning_offers_post

    Returns bookable offers for the given travel plan. &lt;p&gt;Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of \&quot;Date.now()\&quot; is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. &lt;p&gt;In the final check, just before presenting the alternatives to the user, a call should be made using &#x60;booking-intent&#x60;, requesting the TO to provide booking IDs to reference to during communication with the MP. &lt;p&gt;see (2.1) in the process flow - planning # noqa: E501

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

    :rtype: Planning
    """
    if connexion.request.is_json:
        body = PlanningRequest.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'


def plannings_post(accept_language, api, api_version, maas_id, body=None, addressed_to=None, booking_intent=None):  # noqa: E501
    """plannings_post

    Returns plannings for the given travel plan. &lt;p&gt;Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of \&quot;Date.now()\&quot; is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. &lt;p&gt;In the final check, just before presenting the alternatives to the user, a call should be made using &#x60;booking-intent&#x60;, requesting the TO to provide booking IDs to reference to during communication with the MP. &lt;p&gt;see (2.1) in the process flow - planning Replaced by /plannings/inquires (booking-intent false) and /planning/offers (booking-intent true) # noqa: E501

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
    :param booking_intent: Specifies whether IDs should be returned for the leg options that can be referred to when booking
    :type booking_intent: bool

    :rtype: Planning
    """
    if connexion.request.is_json:
        body = PlanningRequest.from_dict(connexion.request.get_json())  # noqa: E501
    return 'do some magic!'
