# coding: utf-8

import sys
from setuptools import setup, find_packages

NAME = "swagger_server"
VERSION = "1.0.0"
# To install the library, run the following
#
# python setup.py install
#
# prerequisite: setuptools
# http://pypi.python.org/pypi/setuptools

REQUIRES = ["connexion"]

setup(
    name=NAME,
    version=VERSION,
    description="Transport Operator MaaS Provider API",
    author_email="",
    url="",
    keywords=["Swagger", "Transport Operator MaaS Provider API"],
    install_requires=REQUIRES,
    packages=find_packages(),
    package_data={'': ['swagger/swagger.yaml']},
    include_package_data=True,
    entry_points={
        'console_scripts': ['swagger_server=swagger_server.__main__:main']},
    long_description="""\
    An API between MaaS providers and transport operators for booking trips and corresponding assets. &lt;p&gt;The documentation (examples, process flows and sequence diagrams) can be found at &lt;a href&#x3D;\&quot;https://github.com/TOMP-WG/TOMP-API/\&quot;&gt;github&lt;/a&gt;.
    """
)
