import kotlin.random.Random

enum class EstadosBebes{
    despierto, 
    llorando, 
    dormido, 
    comiendo, 
    cagado_y_miado, 
    viendo_al_rasho_Macuin, 
    esperando_SilkSong,
    bailando_la_macarena,
    dibujando,
    gano,
    exploto, 
    tieso 
}



class Bebe(
    var nombre: String,
    var hambre: Int,
    var panial_lleno: Int,
    var suenio: Int,
    var batalla: Int,
    var estado: EstadosBebes = EstadosBebes.despierto
){

    //Checador que siga vivo 💀☠️
    fun sigue_vivo(): Boolean{
        if(estado == EstadosBebes.tieso || estado == EstadosBebes.exploto){
            return false;
        }else{
            return true;
        }
    }
    
    
    fun alimentar(){
        if(sigue_vivo()){
            estado = EstadosBebes.comiendo
        }
        return
    }
    
    fun llorando(){
        if(sigue_vivo()){
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
        if(sigue_vivo()){
            if (panial_lleno > 80){
                estado = EstadosBebes.cagado_y_miado
                panial_lleno = 0;
            }
        }
    }
    
    fun waiiitinngg(){
        if(sigue_vivo()){
            estado = EstadosBebes.esperando_SilkSong
        }
    }
    
    fun bailando(){
        if(sigue_vivo()){
            estado = EstadosBebes.bailando_la_macarena
        }
    }
    
    fun dibujar(){
        if(sigue_vivo()){
            estado = EstadosBebes.dibujando
        }
    }
    
    fun despertar_con_agua(){
        if(sigue_vivo()){
            if(estado == EstadosBebes.dormido){
                estado = EstadosBebes.tieso
            }    
        }
        
    }
    
    fun ver_Cars(){
        if(sigue_vivo()){
                estado = EstadosBebes.viendo_al_rasho_Macuin
        }
    }
    
    fun batalla_campal(){
        if(sigue_vivo()){
            batalla = Random.nextInt(0,100);
        
            if(batalla > 49){
                estado = EstadosBebes.gano
            }else{
                estado = EstadosBebes.exploto
            }
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
                suenio +=10
                hambre += 10
                panial_lleno += 10
            }
        }
    }
    
    
    fun estado_actual():String{
    
        when(estado){
            EstadosBebes.despierto -> {
                return "El bebe esta despierto"
            }
            EstadosBebes.llorando -> {
                return "El bebe esta llorando (callenlo porfavor)"
            }
            EstadosBebes.cagado_y_miado -> {
                return "El bebe esta todo cagado encima"
            }
            EstadosBebes.viendo_al_rasho_Macuin -> {
                return "El bebe anda viendo al rasho macuin, joer que basado"
            }
            EstadosBebes.esperando_SilkSong -> {
                return "Esperando Silksong, ya mero sale bebe"
            }
            EstadosBebes.bailando_la_macarena -> {
                return "Esta bailando la macarena, que alguien lo detenga"
            }
            EstadosBebes.dibujando -> {
                return "El bebe anda dibujando geis, que pedoo"
            }
            EstadosBebes.tieso -> {
                return "Estoy muerto Otto"
            }
            EstadosBebes.dormido -> {
                return "Esta dormido"
            }
            EstadosBebes.comiendo -> {
                return "Estoy comiendo"
            }
            EstadosBebes.gano -> {
                return "El bebe le ha ganado a una bomba atomica"
            }
            EstadosBebes.exploto -> {
                return "GOKUUU AHHHHH---- *explota* "
            }
            else -> {
                return "No identifico el estado"
            }
        }
    }
}

fun main(){
    //val JackieShieras = Bebe("Jackie Shieras", 50, 10, 70, 0)
    val AlanBrito = Bebe("Alan Brito", 40, 30, 60, 0)
    
    AlanBrito.despertar()
    println("El estado actual del bebe es: ${AlanBrito.estado_actual()}")
    AlanBrito.actualizar_estado()
    
    AlanBrito.batalla_campal()
    println("El estado actual del bebe es: ${AlanBrito.estado_actual()}")
  
    AlanBrito.ver_Cars()
    println("El estado actual del bebe es: ${AlanBrito.estado_actual()}")
    
    AlanBrito.waiiitinngg()
    println("El estado actual del bebe es: ${AlanBrito.estado_actual()}")
    
    AlanBrito.bailando()
    println("El estado actual del bebe es: ${AlanBrito.estado_actual()}")

    AlanBrito.dibujar()
    println("El estado actual del bebe es: ${AlanBrito.estado_actual()}")
}
    