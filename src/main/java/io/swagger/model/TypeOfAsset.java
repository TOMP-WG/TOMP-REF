package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Asset;
import io.swagger.model.AssetClass;
import io.swagger.model.KeyValue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * what kind of asset is this? Classify it, give the aspects. Most aspects are optional and should be used when applicable.
 */
@ApiModel(description = "what kind of asset is this? Classify it, give the aspects. Most aspects are optional and should be used when applicable.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class TypeOfAsset   {
  @JsonProperty("typeId")
  private String typeId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("assetClass")
  private AssetClass assetClass = null;

  @JsonProperty("assetSubClass")
  private String assetSubClass = null;

  @JsonProperty("amountAvailable")
  private BigDecimal amountAvailable = null;

  @JsonProperty("assets")
  @Valid
  private List<Asset> assets = null;

  /**
   * Gets or Sets fuel
   */
  public enum FuelEnum {
    NONE("NONE"),
    
    GASOLINE("GASOLINE"),
    
    DIESEL("DIESEL"),
    
    ELECTRIC("ELECTRIC"),
    
    HYBRID_GASOLINE("HYBRID_GASOLINE"),
    
    HYBRID_DIESEL("HYBRID_DIESEL"),
    
    HYBRID_GAS("HYBRID_GAS"),
    
    HYDROGEN("HYDROGEN"),
    
    GAS("GAS"),
    
    BIO_MASS("BIO_MASS"),
    
    KEROSINE("KEROSINE"),
    
    OTHER("OTHER");

    private String value;

    FuelEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FuelEnum fromValue(String text) {
      for (FuelEnum b : FuelEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("fuel")
  private FuelEnum fuel = null;

  /**
   * Gets or Sets energyLabel
   */
  public enum EnergyLabelEnum {
    A("A"),
    
    B("B"),
    
    C("C"),
    
    D("D"),
    
    E("E");

    private String value;

    EnergyLabelEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EnergyLabelEnum fromValue(String text) {
      for (EnergyLabelEnum b : EnergyLabelEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("energyLabel")
  private EnergyLabelEnum energyLabel = null;

  @JsonProperty("co2PerKm")
  private BigDecimal co2PerKm = null;

  @JsonProperty("brand")
  private String brand = null;

  @JsonProperty("model")
  private String model = null;

  @JsonProperty("buildingYear")
  private BigDecimal buildingYear = null;

  @JsonProperty("travelAbroad")
  private Boolean travelAbroad = null;

  @JsonProperty("airConditioning")
  private Boolean airConditioning = null;

  @JsonProperty("cabrio")
  private Boolean cabrio = null;

  @JsonProperty("colour")
  private String colour = null;

  @JsonProperty("cargo")
  private String cargo = null;

  /**
   * describes if asset is or needs to be easily accessible
   */
  public enum EasyAccessibilityEnum {
    LIFT("LIFT"),
    
    ESCALATOR("ESCALATOR"),
    
    GROUND_LEVEL("GROUND_LEVEL"),
    
    SIGHTIMPAIRMENT("SIGHTIMPAIRMENT"),
    
    HEARINGIMPAIRMENT("HEARINGIMPAIRMENT"),
    
    WHEELCHAIR("WHEELCHAIR");

    private String value;

    EasyAccessibilityEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EasyAccessibilityEnum fromValue(String text) {
      for (EasyAccessibilityEnum b : EasyAccessibilityEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("easyAccessibility")
  private EasyAccessibilityEnum easyAccessibility = null;

  @JsonProperty("gears")
  private Integer gears = null;

  /**
   * type of gearbox
   */
  public enum GearboxEnum {
    MANUAL("MANUAL"),
    
    AUTOMATIC("AUTOMATIC"),
    
    SEMIAUTOMATIC("SEMIAUTOMATIC");

    private String value;

    GearboxEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GearboxEnum fromValue(String text) {
      for (GearboxEnum b : GearboxEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("gearbox")
  private GearboxEnum gearbox = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("infantSeat")
  private Boolean infantSeat = null;

  @JsonProperty("persons")
  private Integer persons = null;

  @JsonProperty("pets")
  private Boolean pets = null;

  /**
   * way in which the asset is powered
   */
  public enum PropulsionEnum {
    MUSCLE("MUSCLE"),
    
    ELECTRIC("ELECTRIC"),
    
    GASOLINE("GASOLINE"),
    
    DIESEL("DIESEL"),
    
    HYBRID("HYBRID"),
    
    LPG("LPG"),
    
    HYDROGEN("HYDROGEN");

    private String value;

    PropulsionEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PropulsionEnum fromValue(String text) {
      for (PropulsionEnum b : PropulsionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("propulsion")
  private PropulsionEnum propulsion = null;

  @JsonProperty("smoking")
  private Boolean smoking = null;

  @JsonProperty("stateOfCharge")
  private Integer stateOfCharge = null;

  @JsonProperty("towingHook")
  private Boolean towingHook = null;

  @JsonProperty("undergroundParking")
  private Boolean undergroundParking = null;

  @JsonProperty("winterTires")
  private Boolean winterTires = null;

  @JsonProperty("other")
  private String other = null;

  @JsonProperty("meta")
  @Valid
  private List<KeyValue> meta = null;

  public TypeOfAsset typeId(String typeId) {
    this.typeId = typeId;
    return this;
  }

  /**
   * unique identifier of a type, scope TO
   * @return typeId
  **/
  @ApiModelProperty(required = true, value = "unique identifier of a type, scope TO")
      @NotNull

    public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  public TypeOfAsset name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of asset type
   * @return name
  **/
  @ApiModelProperty(required = true, value = "name of asset type")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TypeOfAsset assetClass(AssetClass assetClass) {
    this.assetClass = assetClass;
    return this;
  }

  /**
   * Get assetClass
   * @return assetClass
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public AssetClass getAssetClass() {
    return assetClass;
  }

  public void setAssetClass(AssetClass assetClass) {
    this.assetClass = assetClass;
  }

  public TypeOfAsset assetSubClass(String assetSubClass) {
    this.assetSubClass = assetSubClass;
    return this;
  }

  /**
   * a more precise classification of the asset, like 'cargo bike', 'public bus', 'coach bus', 'office bus', 'water taxi',  'segway'. This is mandatory when using 'OTHER' as class.
   * @return assetSubClass
  **/
  @ApiModelProperty(value = "a more precise classification of the asset, like 'cargo bike', 'public bus', 'coach bus', 'office bus', 'water taxi',  'segway'. This is mandatory when using 'OTHER' as class.")
  
    public String getAssetSubClass() {
    return assetSubClass;
  }

  public void setAssetSubClass(String assetSubClass) {
    this.assetSubClass = assetSubClass;
  }

  public TypeOfAsset amountAvailable(BigDecimal amountAvailable) {
    this.amountAvailable = amountAvailable;
    return this;
  }

  /**
   * Get amountAvailable
   * @return amountAvailable
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getAmountAvailable() {
    return amountAvailable;
  }

  public void setAmountAvailable(BigDecimal amountAvailable) {
    this.amountAvailable = amountAvailable;
  }

  public TypeOfAsset assets(List<Asset> assets) {
    this.assets = assets;
    return this;
  }

  public TypeOfAsset addAssetsItem(Asset assetsItem) {
    if (this.assets == null) {
      this.assets = new ArrayList<Asset>();
    }
    this.assets.add(assetsItem);
    return this;
  }

  /**
   * Get assets
   * @return assets
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Asset> getAssets() {
    return assets;
  }

  public void setAssets(List<Asset> assets) {
    this.assets = assets;
  }

  public TypeOfAsset fuel(FuelEnum fuel) {
    this.fuel = fuel;
    return this;
  }

  /**
   * Get fuel
   * @return fuel
  **/
  @ApiModelProperty(value = "")
  
    public FuelEnum getFuel() {
    return fuel;
  }

  public void setFuel(FuelEnum fuel) {
    this.fuel = fuel;
  }

  public TypeOfAsset energyLabel(EnergyLabelEnum energyLabel) {
    this.energyLabel = energyLabel;
    return this;
  }

  /**
   * Get energyLabel
   * @return energyLabel
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public EnergyLabelEnum getEnergyLabel() {
    return energyLabel;
  }

  public void setEnergyLabel(EnergyLabelEnum energyLabel) {
    this.energyLabel = energyLabel;
  }

  public TypeOfAsset co2PerKm(BigDecimal co2PerKm) {
    this.co2PerKm = co2PerKm;
    return this;
  }

  /**
   * Get co2PerKm
   * @return co2PerKm
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getCo2PerKm() {
    return co2PerKm;
  }

  public void setCo2PerKm(BigDecimal co2PerKm) {
    this.co2PerKm = co2PerKm;
  }

  public TypeOfAsset brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * brand of the asset
   * @return brand
  **/
  @ApiModelProperty(value = "brand of the asset")
  
    public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public TypeOfAsset model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
  **/
  @ApiModelProperty(value = "")
  
    public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public TypeOfAsset buildingYear(BigDecimal buildingYear) {
    this.buildingYear = buildingYear;
    return this;
  }

  /**
   * Get buildingYear
   * @return buildingYear
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getBuildingYear() {
    return buildingYear;
  }

  public void setBuildingYear(BigDecimal buildingYear) {
    this.buildingYear = buildingYear;
  }

  public TypeOfAsset travelAbroad(Boolean travelAbroad) {
    this.travelAbroad = travelAbroad;
    return this;
  }

  /**
   * true indicates asset is allowed to travel abroad
   * @return travelAbroad
  **/
  @ApiModelProperty(value = "true indicates asset is allowed to travel abroad")
  
    public Boolean isTravelAbroad() {
    return travelAbroad;
  }

  public void setTravelAbroad(Boolean travelAbroad) {
    this.travelAbroad = travelAbroad;
  }

  public TypeOfAsset airConditioning(Boolean airConditioning) {
    this.airConditioning = airConditioning;
    return this;
  }

  /**
   * true indicates airconditioning required
   * @return airConditioning
  **/
  @ApiModelProperty(value = "true indicates airconditioning required")
  
    public Boolean isAirConditioning() {
    return airConditioning;
  }

  public void setAirConditioning(Boolean airConditioning) {
    this.airConditioning = airConditioning;
  }

  public TypeOfAsset cabrio(Boolean cabrio) {
    this.cabrio = cabrio;
    return this;
  }

  /**
   * true indicates cabrio required
   * @return cabrio
  **/
  @ApiModelProperty(value = "true indicates cabrio required")
  
    public Boolean isCabrio() {
    return cabrio;
  }

  public void setCabrio(Boolean cabrio) {
    this.cabrio = cabrio;
  }

  public TypeOfAsset colour(String colour) {
    this.colour = colour;
    return this;
  }

  /**
   * colour of the asset
   * @return colour
  **/
  @ApiModelProperty(value = "colour of the asset")
  
    public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public TypeOfAsset cargo(String cargo) {
    this.cargo = cargo;
    return this;
  }

  /**
   * describes options to carry cargo
   * @return cargo
  **/
  @ApiModelProperty(value = "describes options to carry cargo")
  
    public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public TypeOfAsset easyAccessibility(EasyAccessibilityEnum easyAccessibility) {
    this.easyAccessibility = easyAccessibility;
    return this;
  }

  /**
   * describes if asset is or needs to be easily accessible
   * @return easyAccessibility
  **/
  @ApiModelProperty(value = "describes if asset is or needs to be easily accessible")
  
    public EasyAccessibilityEnum getEasyAccessibility() {
    return easyAccessibility;
  }

  public void setEasyAccessibility(EasyAccessibilityEnum easyAccessibility) {
    this.easyAccessibility = easyAccessibility;
  }

  public TypeOfAsset gears(Integer gears) {
    this.gears = gears;
    return this;
  }

  /**
   * number of gears of the asset
   * @return gears
  **/
  @ApiModelProperty(value = "number of gears of the asset")
  
    public Integer getGears() {
    return gears;
  }

  public void setGears(Integer gears) {
    this.gears = gears;
  }

  public TypeOfAsset gearbox(GearboxEnum gearbox) {
    this.gearbox = gearbox;
    return this;
  }

  /**
   * type of gearbox
   * @return gearbox
  **/
  @ApiModelProperty(value = "type of gearbox")
  
    public GearboxEnum getGearbox() {
    return gearbox;
  }

  public void setGearbox(GearboxEnum gearbox) {
    this.gearbox = gearbox;
  }

  public TypeOfAsset image(String image) {
    this.image = image;
    return this;
  }

  /**
   * Get image
   * @return image
  **/
  @ApiModelProperty(value = "")
  
    public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public TypeOfAsset infantSeat(Boolean infantSeat) {
    this.infantSeat = infantSeat;
    return this;
  }

  /**
   * true indicates infant seat required
   * @return infantSeat
  **/
  @ApiModelProperty(value = "true indicates infant seat required")
  
    public Boolean isInfantSeat() {
    return infantSeat;
  }

  public void setInfantSeat(Boolean infantSeat) {
    this.infantSeat = infantSeat;
  }

  public TypeOfAsset persons(Integer persons) {
    this.persons = persons;
    return this;
  }

  /**
   * number of persons able to use the asset
   * @return persons
  **/
  @ApiModelProperty(value = "number of persons able to use the asset")
  
    public Integer getPersons() {
    return persons;
  }

  public void setPersons(Integer persons) {
    this.persons = persons;
  }

  public TypeOfAsset pets(Boolean pets) {
    this.pets = pets;
    return this;
  }

  /**
   * true indicates pets are allowed on asset
   * @return pets
  **/
  @ApiModelProperty(value = "true indicates pets are allowed on asset")
  
    public Boolean isPets() {
    return pets;
  }

  public void setPets(Boolean pets) {
    this.pets = pets;
  }

  public TypeOfAsset propulsion(PropulsionEnum propulsion) {
    this.propulsion = propulsion;
    return this;
  }

  /**
   * way in which the asset is powered
   * @return propulsion
  **/
  @ApiModelProperty(value = "way in which the asset is powered")
  
    public PropulsionEnum getPropulsion() {
    return propulsion;
  }

  public void setPropulsion(PropulsionEnum propulsion) {
    this.propulsion = propulsion;
  }

  public TypeOfAsset smoking(Boolean smoking) {
    this.smoking = smoking;
    return this;
  }

  /**
   * true indicates smoking is allowed on asset
   * @return smoking
  **/
  @ApiModelProperty(value = "true indicates smoking is allowed on asset")
  
    public Boolean isSmoking() {
    return smoking;
  }

  public void setSmoking(Boolean smoking) {
    this.smoking = smoking;
  }

  public TypeOfAsset stateOfCharge(Integer stateOfCharge) {
    this.stateOfCharge = stateOfCharge;
    return this;
  }

  /**
   * percentage of charge available
   * minimum: 0
   * maximum: 100
   * @return stateOfCharge
  **/
  @ApiModelProperty(value = "percentage of charge available")
  
  @Min(0) @Max(100)   public Integer getStateOfCharge() {
    return stateOfCharge;
  }

  public void setStateOfCharge(Integer stateOfCharge) {
    this.stateOfCharge = stateOfCharge;
  }

  public TypeOfAsset towingHook(Boolean towingHook) {
    this.towingHook = towingHook;
    return this;
  }

  /**
   * true indicates towing hook required
   * @return towingHook
  **/
  @ApiModelProperty(value = "true indicates towing hook required")
  
    public Boolean isTowingHook() {
    return towingHook;
  }

  public void setTowingHook(Boolean towingHook) {
    this.towingHook = towingHook;
  }

  public TypeOfAsset undergroundParking(Boolean undergroundParking) {
    this.undergroundParking = undergroundParking;
    return this;
  }

  /**
   * true indicates underground parking is allowed with asset
   * @return undergroundParking
  **/
  @ApiModelProperty(value = "true indicates underground parking is allowed with asset")
  
    public Boolean isUndergroundParking() {
    return undergroundParking;
  }

  public void setUndergroundParking(Boolean undergroundParking) {
    this.undergroundParking = undergroundParking;
  }

  public TypeOfAsset winterTires(Boolean winterTires) {
    this.winterTires = winterTires;
    return this;
  }

  /**
   * true indicates winter tires required
   * @return winterTires
  **/
  @ApiModelProperty(value = "true indicates winter tires required")
  
    public Boolean isWinterTires() {
    return winterTires;
  }

  public void setWinterTires(Boolean winterTires) {
    this.winterTires = winterTires;
  }

  public TypeOfAsset other(String other) {
    this.other = other;
    return this;
  }

  /**
   * free text to describe asset
   * @return other
  **/
  @ApiModelProperty(value = "free text to describe asset")
  
    public String getOther() {
    return other;
  }

  public void setOther(String other) {
    this.other = other;
  }

  public TypeOfAsset meta(List<KeyValue> meta) {
    this.meta = meta;
    return this;
  }

  public TypeOfAsset addMetaItem(KeyValue metaItem) {
    if (this.meta == null) {
      this.meta = new ArrayList<KeyValue>();
    }
    this.meta.add(metaItem);
    return this;
  }

  /**
   * this array can contain extra information about the type of asset. For instance values from the 'Woordenboek Reizigerskenmerken'. [https://github.com/efel85/TOMP-API/issues/17]. These values can also be used in the planning-options.
   * @return meta
  **/
  @ApiModelProperty(value = "this array can contain extra information about the type of asset. For instance values from the 'Woordenboek Reizigerskenmerken'. [https://github.com/efel85/TOMP-API/issues/17]. These values can also be used in the planning-options.")
      @Valid
    public List<KeyValue> getMeta() {
    return meta;
  }

  public void setMeta(List<KeyValue> meta) {
    this.meta = meta;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TypeOfAsset typeOfAsset = (TypeOfAsset) o;
    return Objects.equals(this.typeId, typeOfAsset.typeId) &&
        Objects.equals(this.name, typeOfAsset.name) &&
        Objects.equals(this.assetClass, typeOfAsset.assetClass) &&
        Objects.equals(this.assetSubClass, typeOfAsset.assetSubClass) &&
        Objects.equals(this.amountAvailable, typeOfAsset.amountAvailable) &&
        Objects.equals(this.assets, typeOfAsset.assets) &&
        Objects.equals(this.fuel, typeOfAsset.fuel) &&
        Objects.equals(this.energyLabel, typeOfAsset.energyLabel) &&
        Objects.equals(this.co2PerKm, typeOfAsset.co2PerKm) &&
        Objects.equals(this.brand, typeOfAsset.brand) &&
        Objects.equals(this.model, typeOfAsset.model) &&
        Objects.equals(this.buildingYear, typeOfAsset.buildingYear) &&
        Objects.equals(this.travelAbroad, typeOfAsset.travelAbroad) &&
        Objects.equals(this.airConditioning, typeOfAsset.airConditioning) &&
        Objects.equals(this.cabrio, typeOfAsset.cabrio) &&
        Objects.equals(this.colour, typeOfAsset.colour) &&
        Objects.equals(this.cargo, typeOfAsset.cargo) &&
        Objects.equals(this.easyAccessibility, typeOfAsset.easyAccessibility) &&
        Objects.equals(this.gears, typeOfAsset.gears) &&
        Objects.equals(this.gearbox, typeOfAsset.gearbox) &&
        Objects.equals(this.image, typeOfAsset.image) &&
        Objects.equals(this.infantSeat, typeOfAsset.infantSeat) &&
        Objects.equals(this.persons, typeOfAsset.persons) &&
        Objects.equals(this.pets, typeOfAsset.pets) &&
        Objects.equals(this.propulsion, typeOfAsset.propulsion) &&
        Objects.equals(this.smoking, typeOfAsset.smoking) &&
        Objects.equals(this.stateOfCharge, typeOfAsset.stateOfCharge) &&
        Objects.equals(this.towingHook, typeOfAsset.towingHook) &&
        Objects.equals(this.undergroundParking, typeOfAsset.undergroundParking) &&
        Objects.equals(this.winterTires, typeOfAsset.winterTires) &&
        Objects.equals(this.other, typeOfAsset.other) &&
        Objects.equals(this.meta, typeOfAsset.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeId, name, assetClass, assetSubClass, amountAvailable, assets, fuel, energyLabel, co2PerKm, brand, model, buildingYear, travelAbroad, airConditioning, cabrio, colour, cargo, easyAccessibility, gears, gearbox, image, infantSeat, persons, pets, propulsion, smoking, stateOfCharge, towingHook, undergroundParking, winterTires, other, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TypeOfAsset {\n");
    
    sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    assetClass: ").append(toIndentedString(assetClass)).append("\n");
    sb.append("    assetSubClass: ").append(toIndentedString(assetSubClass)).append("\n");
    sb.append("    amountAvailable: ").append(toIndentedString(amountAvailable)).append("\n");
    sb.append("    assets: ").append(toIndentedString(assets)).append("\n");
    sb.append("    fuel: ").append(toIndentedString(fuel)).append("\n");
    sb.append("    energyLabel: ").append(toIndentedString(energyLabel)).append("\n");
    sb.append("    co2PerKm: ").append(toIndentedString(co2PerKm)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    buildingYear: ").append(toIndentedString(buildingYear)).append("\n");
    sb.append("    travelAbroad: ").append(toIndentedString(travelAbroad)).append("\n");
    sb.append("    airConditioning: ").append(toIndentedString(airConditioning)).append("\n");
    sb.append("    cabrio: ").append(toIndentedString(cabrio)).append("\n");
    sb.append("    colour: ").append(toIndentedString(colour)).append("\n");
    sb.append("    cargo: ").append(toIndentedString(cargo)).append("\n");
    sb.append("    easyAccessibility: ").append(toIndentedString(easyAccessibility)).append("\n");
    sb.append("    gears: ").append(toIndentedString(gears)).append("\n");
    sb.append("    gearbox: ").append(toIndentedString(gearbox)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    infantSeat: ").append(toIndentedString(infantSeat)).append("\n");
    sb.append("    persons: ").append(toIndentedString(persons)).append("\n");
    sb.append("    pets: ").append(toIndentedString(pets)).append("\n");
    sb.append("    propulsion: ").append(toIndentedString(propulsion)).append("\n");
    sb.append("    smoking: ").append(toIndentedString(smoking)).append("\n");
    sb.append("    stateOfCharge: ").append(toIndentedString(stateOfCharge)).append("\n");
    sb.append("    towingHook: ").append(toIndentedString(towingHook)).append("\n");
    sb.append("    undergroundParking: ").append(toIndentedString(undergroundParking)).append("\n");
    sb.append("    winterTires: ").append(toIndentedString(winterTires)).append("\n");
    sb.append("    other: ").append(toIndentedString(other)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
