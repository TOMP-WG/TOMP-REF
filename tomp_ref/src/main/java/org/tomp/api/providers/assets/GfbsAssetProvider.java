package org.tomp.api.providers.assets;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.repository.GbfsRepository;

import io.swagger.model.TypeOfAsset;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "gbfs", matchIfMissing = false)
public class GfbsAssetProvider implements AssetProvider {

	@Autowired
	GbfsRepository repostory;

	private static Random r = new Random();

	@Override
	public TypeOfAsset getTypeOfAsset() {
		List<TypeOfAsset> assets = repostory.getAssets();
		return assets.get(r.nextInt(assets.size()));
	}

	@Override
	public List<TypeOfAsset> getAssetTypes() {
		return repostory.getAssets();
	}
}
