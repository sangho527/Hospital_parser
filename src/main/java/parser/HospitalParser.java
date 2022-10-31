package parser;

import com.springboot.hello1.domain.Hospital;

import java.time.LocalDateTime;
import java.util.Arrays;

public class HospitalParser implements Parser<Hospital> {
    @Override
    public Hospital parse(String str) {

//        1, Id();
//        "의원", OpenServiceName();
//        3620000,OpenLocalGovernmentCode();
//        "PHMA119993620020041100004", ManagementNumber();
//        LocalDateTime.of(1999, 6, 12, 0, 0, 0), LicenseDate(); //19990612
//        6, BusinessStatus();
//        13, BusinessStatusCode();
//        "062-515-2875", Phone();
//        "광주광역시 북구 풍향동 565번지 4호 3층", FullAddress();
//        "광주광역시 북구 동문대로 24, 3층 (풍향동)", RoadNameAddress();
//        "효치과의원", HospitalName();
//        "치과의원", BusinessTypeName();
//        1, HealthcareProviderCount();
//        0, PatientRoomCount();
//        0, TotalNumberOfBeds();
//        52.29, getTotalAreaSize();

        String[] row = str.split("\",\"");
        System.out.println(Arrays.toString(row));

        Hospital hospital = new Hospital();
        hospital.setId(Integer.parseInt(row[0].replace("\n","")));
        hospital.setOpenServiceName(row[1]);
        hospital.setOpenLocalGovernmentCode(Integer.parseInt(row[3]));
        hospital.setManagementNumber(row[4]);

        int year = Integer.parseInt(row[5].substring(0,4));
        int month = Integer.parseInt(row[5].substring(4,6));
        int day = Integer.parseInt(row[5].substring(6,7));
//        System.out.println("%d %d %d \n", year, month, day);
//        hospital.setLicenseDate(LocalDateTime.of(year, month, day, 0, 0, 0));
        hospital.setLisenseDate(LocalDateTime.parse(row[5]));
        hospital.setBusinessStatus(Integer.parseInt(row[7]));
        hospital.setBusinessStatusCode(Integer.parseInt(row[9]));
        hospital.setPhone(row[15]);
        hospital.setFullAddress(row[18]);
        hospital.setRoadNameAddress(row[19]);
        hospital.setHospitalName(row[21]);
        hospital.setBusinessTypeName(row[25]);
        hospital.setHealthcareProviderCount(Integer.parseInt(row[29]));
        hospital.setPatientRoomCount(Integer.parseInt(row[30]));
        hospital.setTotalNumberOfBeds(Integer.parseInt(row[31]));
        hospital.setTotalAreaSize(Float.parseFloat(row[32].replace("\"","")));


        return new Hospital();
    }

}
