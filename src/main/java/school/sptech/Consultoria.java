package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(String nome, Integer vagas, List<Desenvolvedor> desenvolvedores) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if (desenvolvedores.size() < getVagas()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack() == false){
            return false;
        }
        return desenvolvedores.add(desenvolvedor);
    }

    public Double getTotalSalarios(){
        Double total = 0.0;

        for (Desenvolvedor devDaVez : desenvolvedores){
            if (devDaVez instanceof DesenvolvedorMobile){
                total += devDaVez.calcularSalario();
            } else{
                total += devDaVez.calcularSalario();
            }
        }
        return total;
    }

    public Integer qtdDesenvolvedoresMobile(){
        int qtdDesenvolvedorMobile = 0;

        for (int i = 0; i< desenvolvedores.size(); i++){
            Desenvolvedor devDavez = desenvolvedores.get(i);

            if (devDavez instanceof DesenvolvedorMobile){
                qtdDesenvolvedorMobile++;
            }
        }
        return qtdDesenvolvedorMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> maioresSalarios = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor.calcularSalario() >= salario){
                maioresSalarios.add(desenvolvedor);
            }
        }
        return maioresSalarios;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor devMenor = desenvolvedores.get(0);
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor.calcularSalario() < devMenor.calcularSalario()){
                devMenor = desenvolvedor;
            }
        }
        return devMenor;

    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        if(desenvolvedores.isEmpty()){
            return null;
        }

        List<Desenvolvedor> devsPorTecnologia = new ArrayList<>();

        for(var i = 0; i < desenvolvedores.size(); i++){
            Desenvolvedor devDaVez = desenvolvedores.get(i);

            if(devDaVez instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) devDaVez).getFrontend().contains(tecnologia)){
                    devsPorTecnologia.add(devDaVez);
                }
                if(((DesenvolvedorWeb) devDaVez).getBackend().contains(tecnologia)){
                    devsPorTecnologia.add(devDaVez);
                }
                if(((DesenvolvedorWeb) devDaVez).getSgbd().contains(tecnologia)){
                    devsPorTecnologia.add(devDaVez);
                }
            }

            if(devDaVez instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) devDaVez).getPlataforma().contains(tecnologia)){
                    devsPorTecnologia.add(devDaVez);
                }

                if(((DesenvolvedorMobile) devDaVez).getLinguagem().contains(tecnologia)){
                    devsPorTecnologia.add(devDaVez);
                }
            }
        }

        return devsPorTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double salario = 0.0;

        List<Desenvolvedor> tecnologias = buscarPorTecnologia(tecnologia);

        for (Desenvolvedor desenvolvedor : tecnologias){
            salario += desenvolvedor.calcularSalario();
        }
        return salario;
    }
}
