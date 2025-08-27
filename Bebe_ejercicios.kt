import kotlin.random.Random

enum class EstadosBebes{
    despierto, //
    llorando, 
    dormido, //
    comiendo, //
    cagado_y_miado, 
    viendo_al_rasho_Macuin, //
    esperando_SilkSong,
    bailando_la_macarena,
    dibujando,
    gano, //
    exploto, //
    tieso //
}



class Bebe(
    var nombre: String,
    var hambre: Int,
    var panial_lleno: Int,
    var suenio: Int,
    var batalla: Int,
    var estado: EstadosBebes = EstadosBebes.despierto
){
    fun alimentar(){
        if(sigue_vivo() && esta_despierto()){
            estado = EstadosBebes.comiendo
        }
    }
    
    fun llorando(){
        if(sigue_vivo() && esta_despierto()){
            estado = EstadosBebes.llorando
        }
    }
    
    fun dormir(){
        if(sigue_vivo()){
            if ((estado == EstadosBebes.despierto || estado == EstadosBebes.comiendo) && suenio > 49){
            suenio = 0
            estado = EstadosBebes.dormido
            }
            else{
                estado = EstadosBebes.despierto
            }
        }
        
    }
    
    fun despertar(){
        if(sigue_vivo()){
            if(estado == EstadosBebes.dormido){
                estado = EstadosBebes.despierto
            }
        }

    }
    
    fun checar_panial(){
        if(sigue_vivo() && esta_despierto()){
            if (panial_lleno > 80){
                estado = EstadosBebes.cagado_y_miado
                panial_lleno = 0;
            }
    }
    
    fun waiiitinngg(){
        if(sigue_vivo() && esta_despierto()){
            estado = EstadosBebes.esperando_SilkSong
        }
    }
    
    fun bailando(){
        if(sigue_vivo() && esta_despierto()){
            estado = EstadosBebes.bailando_la_macarena
        }
    }
    
    fun dibujar(){
        if(sigue_vivo() && esta_despierto()){
            estado = EstadosBebes.dibujando
        }
    }
    
    fun despertar_con_agua(){
        if(sigue_vivo){
            if(estado == EstadosBebes.dormido){
                estado = EstadosBebes.tieso
            }    
        }
        
    }
    
    fun ver_Cars(){
        if(sigue_vivo() && esta_despierto()){
                estado = EstadosBebes.viendo_al_rasho_Macuin
        }
    }
    
    fun batalla_campal(){
        if(sigue_vivo() && esta_despierto()){
            batalla = Random.nextInt(0,100) - suenio;
        
            if(batalla > 49){
                estado = EstadosBebes.gano
            }else{
                estado = EstadosBebes.exploto
            }
        }
        
    }
    
    //Checador que siga vivo 💀☠️
    fun sigue_vivo(): Boolean{
        if(estado == EstadosBebes.tieso || estado == EstadosBebes.exploto){
            return false;
        }else{
            return true;
        }
    }
    
    //Checar que no este dormido 🦐
    fun esta_despierto():Boolean{
        if(estado == EstadosBebes.despierto){
            return true;
        }else{
            return false;
        }
    }
    
    fun actualizar_estado(){
        
        when(estado){
            EstadosBebes.despierto ->{
                suenio += 5
                hambre += 5
                panial_lleno += 3
            }
            EstadosBebes.llorando ->{
                suenio += 10
                hambre += 5
                panial_lleno += 40
            }
            EstadosBebes.comiendo ->{
                hambre -= 40
                suenio +=20
            }
            EstadosBebes.viendo_al_rasho_Macuin ->{
                suenio +=20
                hambre +=10
                panial_lleno += 5
            }
            EstadosBebes.gano ->{
                suenio += 50
                hambre += 50
                panial_lleno += 40
            }
            EstadosBebes.esperando_SilkSong ->{
                suenio += 40
                hambre += 10
                panial_lleno += 15
            }
            EstadosBebes.bailando_la_macarena ->{
                suenio += 80
                hambre += 15
                panial_lleno += 20
            }
            EstadosBebes.dibujando ->{
                suenio += 80
                hambre += 20
                panial_lleno += 15
            }
            
            else ->{
                
            }
        }
    }
    
    fun picar_con_un_palo(): String{
        return estado_actual()
    }
    
    fun estado_actual():String{
    
        when(estado){
            EstadosBebes.despierto -> {
                return "El bebe esta despierto"
            }
            EstadosBebes.llorando ->{
                return "El bebe esta llorando (callenlo porfavor)"
            }
            EstadosBebes.cagado_y_miado ->{
                return "El bebe esta todo cagado encima"
            }
            EstadosBebes.viendo_al_rasho_Macuin ->{
                return "El bebe anda viendo al rasho macuin, joer que basado"
            }
            EstadosBebes.esperando_SilkSong ->{
                return "Esperando Silksong, ya mero sale bebe"
            }
            EstadosBebes.bailando_la_macarena ->{
                return "Esta bailando la macarena, que alguien lo detenga"
            }
            EstadosBebes.dibujar ->{
                return "El bebe anda dibujando geis, que pedoo"
            }
            EstadosBebes.tieso ->{
                return "Estoy muerto Otto"
            }
            EstadosBebes.dormido ->{
                return "Esta dormido"
            }
            EstadosBebes.comiendo ->{
                return "Estoy comiendo"
            }
            EstadosBebes.gano ->{
                return "El bebe le ha ganado a una bomba atomica"
            }
            EstadosBebes.exploto ->{
                return "GOKUUU AHHHHH---- *explota* "
            }
            else -> {
                return "No identifico el estado"
            }
        }
    }
}

fun main(){
    val JackieShieras = Bebe("Jackie Shieras", 50, 10, 70,0)
    val AnalBrito = Bebe("Alan Brito", 40, 20, 60, 0)
    
    JackieShieras.actualizar_estado()
    println("El estado del bebe es ${JackieShieras.estado_actual()}")
    JackieShieras.dormir()
    println("El estado del bebe es ${JackieShieras.estado_actual()}")
    JackieShieras.batalla_campal()
    println("El estado del bebe es ${JackieShieras.estado_actual()}")
    JackieShieras.dormir()
    println("El estado del bebe es ${JackieShieras.estado_actual()}")
    
}