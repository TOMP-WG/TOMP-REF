# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server import util


class AssetAccessMethods(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """

    """
    allowed enum values
    """
    DEEPLINK = "DEEPLINK"
    QR = "QR"
    AZTEC = "AZTEC"
    TOMP_API = "TOMP-API"
    AXA_EKEY_OTP = "AXA-EKEY-OTP"
    PHYSICAL_KEY = "PHYSICAL-KEY"
    BARCODE = "BARCODE"
    PDF = "PDF"
    HTML = "HTML"
    OVC = "OVC"
    EMV = "EMV"
    NONE = "NONE"
    def __init__(self):  # noqa: E501
        """AssetAccessMethods - a model defined in Swagger

        """
        self.swagger_types = {
        }

        self.attribute_map = {
        }

    @classmethod
    def from_dict(cls, dikt) -> 'AssetAccessMethods':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The assetAccessMethods of this AssetAccessMethods.  # noqa: E501
        :rtype: AssetAccessMethods
        """
        return util.deserialize_model(dikt, cls)
