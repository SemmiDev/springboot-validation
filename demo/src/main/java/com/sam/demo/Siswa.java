package com.sam.demo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Siswa implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nisn;
    private String nama;
    private String kelas;
    private Jurusan jurusan;
    private Integer umur;
    private Integer tanggalLahir;
    private Integer bulanLahir;
    private Integer tahunLahir;
    private String email;
    private String noTelp;
    private String alamat;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Date(System.currentTimeMillis());
    }

    public Siswa(Long id, String nisn, String nama, String kelas, Jurusan jurusan, Integer umur, Integer tanggalLahir, Integer bulanLahir, Integer tahunLahir, String email, String noTelp, String alamat, Date createdAt, Date updatedAt) {
        this.id = id;
        this.nisn = nisn;
        this.nama = nama;
        this.kelas = kelas;
        this.jurusan = jurusan;
        this.umur = umur;
        this.tanggalLahir = tanggalLahir;
        this.bulanLahir = bulanLahir;
        this.tahunLahir = tahunLahir;
        this.email = email;
        this.noTelp = noTelp;
        this.alamat = alamat;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Siswa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Integer getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Integer tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Integer getBulanLahir() {
        return bulanLahir;
    }

    public void setBulanLahir(Integer bulanLahir) {
        this.bulanLahir = bulanLahir;
    }

    public Integer getTahunLahir() {
        return tahunLahir;
    }

    public void setTahunLahir(Integer tahunLahir) {
        this.tahunLahir = tahunLahir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}

enum Jurusan {
    MIPA, IPS
}

@Repository
interface SiswaRepository extends JpaRepository<Siswa, Long> {}

class SiswaRequest implements Serializable {

    private Long id;
    private String nisn;
    private String nama;
    private String kelas;
    private Jurusan jurusan;
    private Integer umur;
    private Integer tanggalLahir;
    private Integer bulanLahir;
    private Integer tahunLahir;
    private String email;
    private String noTelp;
    private String alamat;

    public SiswaRequest() {
    }

    public SiswaRequest(Long id, String nisn, String nama, String kelas, Jurusan jurusan, Integer umur, Integer tanggalLahir, Integer bulanLahir, Integer tahunLahir, String email, String noTelp, String alamat) {
        this.id = id;
        this.nisn = nisn;
        this.nama = nama;
        this.kelas = kelas;
        this.jurusan = jurusan;
        this.umur = umur;
        this.tanggalLahir = tanggalLahir;
        this.bulanLahir = bulanLahir;
        this.tahunLahir = tahunLahir;
        this.email = email;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Integer getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Integer tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Integer getBulanLahir() {
        return bulanLahir;
    }

    public void setBulanLahir(Integer bulanLahir) {
        this.bulanLahir = bulanLahir;
    }

    public Integer getTahunLahir() {
        return tahunLahir;
    }

    public void setTahunLahir(Integer tahunLahir) {
        this.tahunLahir = tahunLahir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

@Service
class SiswaService {

    private final SiswaRepository siswaRepository;
    private final ObjectMapper objectMapper;
    private final SiswaValidation siswaValidation;

    @Autowired
    public SiswaService(SiswaRepository siswaRepository,
                        ObjectMapper objectMapper,
                        SiswaValidation siswaValidation) {
        this.siswaRepository = siswaRepository;
        this.objectMapper = objectMapper;
        this.siswaValidation = siswaValidation;
    }

    public SiswaRequest save(SiswaRequest siswaRequest) {
        System.err.println("siswa service on save");

        siswaValidation.nisnValidate(siswaRequest.getNisn());
        siswaValidation.nameValidate(siswaRequest.getNama());
        siswaValidation.emailValidate(siswaRequest.getEmail());

        Siswa siswa = objectMapper.convertValue(siswaRequest, Siswa.class);
        Siswa save = siswaRepository.save(siswa);
        return objectMapper.convertValue(save, SiswaRequest.class);
    }
}

@Component
class SiswaValidation {

    List<String> available = List.of(
            "Sammidev4@gmail.com",
            "sam@gmail@gmail.com",
            "test@gmail.com"
    );

    public void nameValidate(String nama) {
        System.err.println("validasi siswa on name");
        if (nama == null) throw new ValidateException("name not null");
        if (nama.length() > 40 || nama.length() < 3) throw new ValidateException("name must range 2 to 40");
    }

    public void emailValidate(String email) {
        System.err.println("validasi siswa on email");
        if (email == null) throw new ValidateException("email not null");
        if (!email.contains("@")) throw new ValidateException("email must contains @");

        for (String mail : available) {
            if (email.equalsIgnoreCase(mail)) {
                throw new ValidateException("email sudah tersedia");
            }
        }
    }

    public void nisnValidate(String nisn) {
        if (nisn.length() != 5) throw new ValidateException("nisn must 5");
    }

    public void jurusanValidate(Jurusan jurusan){
        if (!jurusan.equals(Jurusan.MIPA) || !jurusan.equals(Jurusan.IPS)){
            throw new ValidateException("MIPA / IPS");
        }
    }
}

@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
class ValidateException extends RuntimeException{
    public ValidateException(String message) {
        super(message);
    }
}

@RestController
class SiswaController {

    private final SiswaService siswaService;

    @Autowired
    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @PostMapping("/student")
    public ResponseEntity<?> postStudents(@RequestBody SiswaRequest siswaRequest) {
        return ResponseEntity.ok(siswaService.save(siswaRequest));
    }
}

@Configuration
class ApplicationConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}