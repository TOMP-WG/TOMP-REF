# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server import util


class JournalCategory(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """

    """
    allowed enum values
    """
    ALL = "ALL"
    DAMAGE = "DAMAGE"
    LOSS = "LOSS"
    STOLEN = "STOLEN"
    EXTRA_USAGE = "EXTRA_USAGE"
    REFUND = "REFUND"
    FINE = "FINE"
    OTHER_ASSET_USED = "OTHER_ASSET_USED"
    CREDIT = "CREDIT"
    VOUCHER = "VOUCHER"
    DEPOSIT = "DEPOSIT"
    OTHER = "OTHER"
    def __init__(self):  # noqa: E501
        """JournalCategory - a model defined in Swagger

        """
        self.swagger_types = {
        }

        self.attribute_map = {
        }

    @classmethod
    def from_dict(cls, dikt) -> 'JournalCategory':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The journalCategory of this JournalCategory.  # noqa: E501
        :rtype: JournalCategory
        """
        return util.deserialize_model(dikt, cls)