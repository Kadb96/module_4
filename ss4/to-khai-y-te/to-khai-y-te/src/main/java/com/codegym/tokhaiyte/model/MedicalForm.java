package com.codegym.tokhaiyte.model;

import java.time.LocalDate;

public class MedicalForm {
    private long id;
    private String name;
    private int yearOfBirth;
    private String gender;
    private String country;
    private String idNumber;
    private String transporter;
    private String transporterNumber;
    private String seatNumber;
    private String startDate;
    private String endDate;
    private String cityIn14Day;
    private String cityContact;
    private String districtContact;
    private String wardContact;
    private String addressContact;
    private String phoneContact;
    private String emailContact;
    private boolean fever;
    private boolean cough;
    private boolean hardToBreath;
    private boolean soreThroat;
    private boolean vomit;
    private boolean diarrhea;
    private boolean externalBleeding;
    private boolean externalLump;
    private boolean nearRanchIn14Day;
    private boolean in2MeterWithCovid;

    public MedicalForm() {
    }

    public MedicalForm(long id, String name, int yearOfBirth, String gender, String country, String idNumber,
                       String transporter, String transporterNumber, String seatNumber, String startDate,
                       String endDate, String cityIn14Day, String cityContact, String districtContact,
                       String wardContact, String addressContact, String phoneContact, String emailContact,
                       boolean fever, boolean cough, boolean hardToBreath, boolean soreThroat, boolean vomit,
                       boolean diarrhea, boolean externalBleeding, boolean externalLump, boolean nearRanchIn14Day,
                       boolean in2MeterWithCovid) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.country = country;
        this.idNumber = idNumber;
        this.transporter = transporter;
        this.transporterNumber = transporterNumber;
        this.seatNumber = seatNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cityIn14Day = cityIn14Day;
        this.cityContact = cityContact;
        this.districtContact = districtContact;
        this.wardContact = wardContact;
        this.addressContact = addressContact;
        this.phoneContact = phoneContact;
        this.emailContact = emailContact;
        this.fever = fever;
        this.cough = cough;
        this.hardToBreath = hardToBreath;
        this.soreThroat = soreThroat;
        this.vomit = vomit;
        this.diarrhea = diarrhea;
        this.externalBleeding = externalBleeding;
        this.externalLump = externalLump;
        this.nearRanchIn14Day = nearRanchIn14Day;
        this.in2MeterWithCovid = in2MeterWithCovid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getTransporter() {
        return transporter;
    }

    public void setTransporter(String transporter) {
        this.transporter = transporter;
    }

    public String getTransporterNumber() {
        return transporterNumber;
    }

    public void setTransporterNumber(String transporterNumber) {
        this.transporterNumber = transporterNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCityIn14Day() {
        return cityIn14Day;
    }

    public void setCityIn14Day(String cityIn14Day) {
        this.cityIn14Day = cityIn14Day;
    }

    public String getCityContact() {
        return cityContact;
    }

    public void setCityContact(String cityContact) {
        this.cityContact = cityContact;
    }

    public String getDistrictContact() {
        return districtContact;
    }

    public void setDistrictContact(String districtContact) {
        this.districtContact = districtContact;
    }

    public String getWardContact() {
        return wardContact;
    }

    public void setWardContact(String wardContact) {
        this.wardContact = wardContact;
    }

    public String getAddressContact() {
        return addressContact;
    }

    public void setAddressContact(String addressContact) {
        this.addressContact = addressContact;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isHardToBreath() {
        return hardToBreath;
    }

    public void setHardToBreath(boolean hardToBreath) {
        this.hardToBreath = hardToBreath;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isVomit() {
        return vomit;
    }

    public void setVomit(boolean vomit) {
        this.vomit = vomit;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isExternalBleeding() {
        return externalBleeding;
    }

    public void setExternalBleeding(boolean externalBleeding) {
        this.externalBleeding = externalBleeding;
    }

    public boolean isExternalLump() {
        return externalLump;
    }

    public void setExternalLump(boolean externalLump) {
        this.externalLump = externalLump;
    }

    public boolean isNearRanchIn14Day() {
        return nearRanchIn14Day;
    }

    public void setNearRanchIn14Day(boolean nearRanchIn14Day) {
        this.nearRanchIn14Day = nearRanchIn14Day;
    }

    public boolean isIn2MeterWithCovid() {
        return in2MeterWithCovid;
    }

    public void setIn2MeterWithCovid(boolean in2MeterWithCovid) {
        this.in2MeterWithCovid = in2MeterWithCovid;
    }
}
