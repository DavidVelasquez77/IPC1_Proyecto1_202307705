package src;

public class Cita {
    protected String NombrePaciente;
    protected String HoraCita;
    protected String FechaCita;
    protected String Motivo;

    public Cita(String MotivoString, String NombrePaciente, String HoraCita, String FechaCita) {
        this. Motivo = MotivoString;
        this.NombrePaciente = NombrePaciente;
        this.HoraCita = HoraCita;
        this.FechaCita = FechaCita;
    }
    public String getMotivo(){
        return Motivo;
    }
    public void setMotivo(String Motivo){
        this.Motivo = Motivo;
    }

    public String getNombrePaciente() {
        return NombrePaciente;
    }

    public void setNombrePaciente(String NombrePaciente) {
        this.NombrePaciente = NombrePaciente;
    }

    public String getHoraCita() {
        return HoraCita;
    }

    public void setHoraCita(String HoraCita) {
        this.HoraCita = HoraCita;
    }

}
