# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server import util


class Error(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, errorcode: float=None, type: str=None, title: str=None, status: int=None, detail: str=None, instance: str=None):  # noqa: E501
        """Error - a model defined in Swagger

        :param errorcode: The errorcode of this Error.  # noqa: E501
        :type errorcode: float
        :param type: The type of this Error.  # noqa: E501
        :type type: str
        :param title: The title of this Error.  # noqa: E501
        :type title: str
        :param status: The status of this Error.  # noqa: E501
        :type status: int
        :param detail: The detail of this Error.  # noqa: E501
        :type detail: str
        :param instance: The instance of this Error.  # noqa: E501
        :type instance: str
        """
        self.swagger_types = {
            'errorcode': float,
            'type': str,
            'title': str,
            'status': int,
            'detail': str,
            'instance': str
        }

        self.attribute_map = {
            'errorcode': 'errorcode',
            'type': 'type',
            'title': 'title',
            'status': 'status',
            'detail': 'detail',
            'instance': 'instance'
        }
        self._errorcode = errorcode
        self._type = type
        self._title = title
        self._status = status
        self._detail = detail
        self._instance = instance

    @classmethod
    def from_dict(cls, dikt) -> 'Error':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The error of this Error.  # noqa: E501
        :rtype: Error
        """
        return util.deserialize_model(dikt, cls)

    @property
    def errorcode(self) -> float:
        """Gets the errorcode of this Error.

        The TOMP specific error code. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for more details of this error.  # noqa: E501

        :return: The errorcode of this Error.
        :rtype: float
        """
        return self._errorcode

    @errorcode.setter
    def errorcode(self, errorcode: float):
        """Sets the errorcode of this Error.

        The TOMP specific error code. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for more details of this error.  # noqa: E501

        :param errorcode: The errorcode of this Error.
        :type errorcode: float
        """

        self._errorcode = errorcode

    @property
    def type(self) -> str:
        """Gets the type of this Error.

        The category of this type of error.  # noqa: E501

        :return: The type of this Error.
        :rtype: str
        """
        return self._type

    @type.setter
    def type(self, type: str):
        """Sets the type of this Error.

        The category of this type of error.  # noqa: E501

        :param type: The type of this Error.
        :type type: str
        """

        self._type = type

    @property
    def title(self) -> str:
        """Gets the title of this Error.

        A short, human-readable summary of the problem type.  It SHOULD NOT change from occurrence to occurrence of the problem, except to match Content-Language  # noqa: E501

        :return: The title of this Error.
        :rtype: str
        """
        return self._title

    @title.setter
    def title(self, title: str):
        """Sets the title of this Error.

        A short, human-readable summary of the problem type.  It SHOULD NOT change from occurrence to occurrence of the problem, except to match Content-Language  # noqa: E501

        :param title: The title of this Error.
        :type title: str
        """

        self._title = title

    @property
    def status(self) -> int:
        """Gets the status of this Error.

        The HTTP status code ([RFC7231], Section 6) generated by the origin server for this occurrence of the problem.  # noqa: E501

        :return: The status of this Error.
        :rtype: int
        """
        return self._status

    @status.setter
    def status(self, status: int):
        """Sets the status of this Error.

        The HTTP status code ([RFC7231], Section 6) generated by the origin server for this occurrence of the problem.  # noqa: E501

        :param status: The status of this Error.
        :type status: int
        """

        self._status = status

    @property
    def detail(self) -> str:
        """Gets the detail of this Error.

        A human-readable explanation specific to this occurrence of the problem, could match Content-Language  # noqa: E501

        :return: The detail of this Error.
        :rtype: str
        """
        return self._detail

    @detail.setter
    def detail(self, detail: str):
        """Sets the detail of this Error.

        A human-readable explanation specific to this occurrence of the problem, could match Content-Language  # noqa: E501

        :param detail: The detail of this Error.
        :type detail: str
        """

        self._detail = detail

    @property
    def instance(self) -> str:
        """Gets the instance of this Error.

        A URI reference that identifies the specific occurrence of the problem.  It may or may not yield further information if dereferenced.  # noqa: E501

        :return: The instance of this Error.
        :rtype: str
        """
        return self._instance

    @instance.setter
    def instance(self, instance: str):
        """Sets the instance of this Error.

        A URI reference that identifies the specific occurrence of the problem.  It may or may not yield further information if dereferenced.  # noqa: E501

        :param instance: The instance of this Error.
        :type instance: str
        """

        self._instance = instance