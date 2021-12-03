import connexion
import six

from swagger_server.models.error import Error  # noqa: E501
from swagger_server.models.extra_costs import ExtraCosts  # noqa: E501
from swagger_server.models.journal_entry import JournalEntry  # noqa: E501
from swagger_server.models.journal_state import JournalState  # noqa: E501
from swagger_server import util


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
