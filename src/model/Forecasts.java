/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lefteris
 */
@Entity
@Table(name = "FORECASTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forecasts.findAll", query = "SELECT f FROM Forecasts f")
    , @NamedQuery(name = "Forecasts.findByForecastid", query = "SELECT f FROM Forecasts f WHERE f.forecastid = :forecastid")
    , @NamedQuery(name = "Forecasts.findByMaintemp", query = "SELECT f FROM Forecasts f WHERE f.maintemp = :maintemp")
    , @NamedQuery(name = "Forecasts.findByCloudsall", query = "SELECT f FROM Forecasts f WHERE f.cloudsall = :cloudsall")
    , @NamedQuery(name = "Forecasts.findByWindspeed", query = "SELECT f FROM Forecasts f WHERE f.windspeed = :windspeed")
    , @NamedQuery(name = "Forecasts.findByDt", query = "SELECT f FROM Forecasts f WHERE f.dt = :dt")
    , @NamedQuery(name = "Forecasts.findByRain", query = "SELECT f FROM Forecasts f WHERE f.rain = :rain")
    , @NamedQuery(name = "Forecasts.findBySnow", query = "SELECT f FROM Forecasts f WHERE f.snow = :snow")
    , @NamedQuery(name = "Forecasts.findByIcon", query = "SELECT f FROM Forecasts f WHERE f.icon = :icon")})
public class Forecasts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FORECASTID")
    private Long forecastid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MAINTEMP")
    private Double maintemp;
    @Column(name = "CLOUDSALL")
    private Double cloudsall;
    @Column(name = "WINDSPEED")
    private Double windspeed;
    @Column(name = "DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt;
    @Column(name = "RAIN")
    private Double rain;
    @Column(name = "SNOW")
    private Double snow;
    @Column(name = "ICON")
    private String icon;
    @JoinColumn(name = "CITYID", referencedColumnName = "CITYID")
    @ManyToOne
    private Cities cityid;
    @JoinColumn(name = "WEATHER_DESC_ID", referencedColumnName = "WEATHER_DESC_ID")
    @ManyToOne
    private WeatherDescs weatherDescId;

    public Forecasts() {
    }

    public Forecasts(Long forecastid) {
        this.forecastid = forecastid;
    }

    public Long getForecastid() {
        return forecastid;
    }

    public void setForecastid(Long forecastid) {
        this.forecastid = forecastid;
    }

    public Double getMaintemp() {
        return maintemp;
    }

    public void setMaintemp(Double maintemp) {
        this.maintemp = maintemp;
    }

    public Double getCloudsall() {
        return cloudsall;
    }

    public void setCloudsall(Double cloudsall) {
        this.cloudsall = cloudsall;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Double getSnow() {
        return snow;
    }

    public void setSnow(Double snow) {
        this.snow = snow;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Cities getCityid() {
        return cityid;
    }

    public void setCityid(Cities cityid) {
        this.cityid = cityid;
    }

    public WeatherDescs getWeatherDescId() {
        return weatherDescId;
    }

    public void setWeatherDescId(WeatherDescs weatherDescId) {
        this.weatherDescId = weatherDescId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forecastid != null ? forecastid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forecasts)) {
            return false;
        }
        Forecasts other = (Forecasts) object;
        if ((this.forecastid == null && other.forecastid != null) || (this.forecastid != null && !this.forecastid.equals(other.forecastid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Forecasts[ forecastid=" + forecastid + " ]";
    }
    
}