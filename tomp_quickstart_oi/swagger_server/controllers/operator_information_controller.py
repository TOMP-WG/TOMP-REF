from base.json_util import JsonUtil as json_util

def operator_alerts_get(accept_language, api, api_version, maas_id, addressed_to=None, offset=None, limit=None, region_id=None, station_id=None):  # noqa: E501
    return json_util.read_all_json('alerts.json')

def operator_available_assets_get(accept_language, api, api_version, maas_id, addressed_to=None, offset=None, limit=None, region_id=None, station_id=None):  # noqa: E501
    return json_util.read_all_json('available_assets.json')

def operator_information_get(accept_language, api, api_version, maas_id, addressed_to=None):  # noqa: E501
    return json_util.read_all_json('information.json')

def operator_meta_get(accept_language, maas_id, addressed_to=None):  # noqa: E501
    return json_util.read_all_json('meta.json')

def operator_operating_calendar_get(accept_language, api, api_version, maas_id, addressed_to=None, region_id=None, station_id=None):  # noqa: E501
    return json_util.read_all_json('operating_calendar.json')

def operator_operating_hours_get(accept_language, api, api_version, maas_id, addressed_to=None, region_id=None, station_id=None):  # noqa: E501
    return json_util.read_all_json('operating_hours.json')

def operator_ping_get(accept_language):  # noqa: E501
    return json_util.read_all_json('ping.json')

def operator_pricing_plans_get(accept_language, api, api_version, maas_id, addressed_to=None, region_id=None, station_id=None):  # noqa: E501
    return json_util.read_all_json('pricing_plans.json')

def operator_regions_get(accept_language, api, api_version, maas_id, addressed_to=None, offset=None, limit=None):  # noqa: E501
    return json_util.read_all_json('regions.json')

def operator_stations_get(accept_language, api, api_version, maas_id, addressed_to=None, offset=None, limit=None, region_id=None, lon=None, lat=None, radius=None):  # noqa: E501
    return json_util.read_all_json('stations.json')