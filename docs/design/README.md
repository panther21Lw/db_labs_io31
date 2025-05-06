# Проєктування бази даних

## Модель бізнес обʼєктів

@startuml

    skinparam style strictuml
    
    ' ==================== User ====================
    entity User #99CC66
    entity User.id #CDE7B0
    entity User.first_name #CDE7B0
    entity User.last_name #CDE7B0
    entity User.age #CDE7B0
    entity User.email #CDE7B0
    entity User.password #CDE7B0
    entity User.phone_number #CDE7B0
    
    User.id --* User
    User.first_name --* User
    User.last_name --* User
    User.age --* User
    User.email --* User
    User.password --* User
    User.phone_number --* User
    
    ' ==================== Role ====================
    entity Role #FFCC66
    entity Role.id #FFE7B0
    entity Role.status #FFE7B0
    entity Role.description #FFE7B0
    
    Role.id --* Role
    Role.status --* Role
    Role.description --* Role
    
    ' ==================== Response ====================
    entity Response #66CCCC
    entity Response.id #B0E7E7
    entity Response.description #B0E7E7
    entity Response.graphic #B0E7E7
    
    Response.id --* Response
    Response.description --* Response
    Response.graphic --* Response
    
    ' ==================== Request ====================
    entity Request #FF99CC
    entity Request.id #F6C9DD
    entity Request.time #F6C9DD
    entity Request.url #F6C9DD
    
    Request.id --* Request
    Request.time --* Request
    Request.url --* Request
    
    ' ==================== Context ====================
    entity Context #9999FF
    entity Context.id #CCCCFF
    entity Context.filter #CCCCFF
    entity Context.category #CCCCFF
    entity Context.date #CCCCFF
    
    Context.id --* Context
    Context.filter --* Context
    Context.category --* Context
    Context.date --* Context
    
    ' ==================== Request_Context ====================
    entity Request_Context #D5B8FF
    
    ' ==================== DataSet ====================
    entity DataSet #6699CC
    entity DataSet.id #AFCBE9
    entity DataSet.text #AFCBE9
    entity DataSet.image_url #AFCBE9
    entity DataSet.diagram #AFCBE9
    entity DataSet.label #AFCBE9
    entity DataSet.source #AFCBE9
    entity DataSet.created_att #AFCBE9
    
    DataSet.id --* DataSet
    DataSet.text --* DataSet
    DataSet.image_url --* DataSet
    DataSet.diagram --* DataSet
    DataSet.label --* DataSet
    DataSet.source --* DataSet
    DataSet.created_att --* DataSet
    
    ' ==================== Request_Response ====================
    entity Request_Response #CCE5FF
    
    ' ==================== Feedback ====================
    entity Feedback #CC9966
    entity Feedback.id #E6C6A5
    entity Feedback.response_id #E6C6A5
    entity Feedback.user_id #E6C6A5
    entity Feedback.title #E6C6A5
    entity Feedback.comment #E6C6A5
    
    Feedback.id --* Feedback
    Feedback.response_id --* Feedback
    Feedback.user_id --* Feedback
    Feedback.title --* Feedback
    Feedback.comment --* Feedback
    
    
    User "0,*" -d- "1,1" Role
    User "1,1" -d- "0,*" Request
    User "1,1" -d- "0,*" Response
    User "1,1" -d- "0,*" Feedback
    
    Request "1,1" -d- "0,*" Request_Context
    Request_Context "0,*" -d- "1,1" Context
    
    Request "1,1" -d- "0,*" Request_Response
    Request_Response "0,*" -d- "1,1" Response
    
    Response "1,1" -d- "0,*" DataSet
    Response "1,1" -d- "0,*" Feedback

@enduml

<hr>
<br>

## ER-Модель

@startuml
    left to right direction
    
    entity User {
        id : serial
        --
        first_name : varchar
        last_name : varchar
        age : integer
        email : varchar
        password : varchar
        phone_number : varchar
    }
    
    entity Role {
        id : serial
        --
        status : varchar
        description : text
    }
    
    entity Response {
        id : serial
        --
        description : text
        graphic : text
    }
    
    entity Request {
        id : serial
        --
        time : timestamp
        url : varchar
    }
    
    entity Context {
        id : serial
        --
        filter : varchar
        category : varchar
        date : date
    }
    
    entity Request_Context {
        id : serial
        --
        request_id: bigint
        context_id: bigint
    }
    
    entity DataSet {
        id : serial
        --
        text : text
        image_url : varchar
        diagram : text
        label : varchar
        source : varchar
        created_att : timestamp
    }
    
    entity Request_Response {
        id : serial
        --
        request_id: bigint
        response_id: bigint
    }
    
    entity Feedback {
        id : serial
        --
        response_id : integer
        user_id : integer
        title : varchar
        comment : text
    }
    
    User "0..*" -- "1" Role
    User "1" -- "0..*" Request
    User "1" -- "0..*" Response
    User "1" -- "0..*" Feedback
    
    Request "1" -- "0..*" Request_Context
    Request_Context "0..*" -- "1" Context
    
    Request "1" -- "0..*" Request_Response
    Request_Response "0..*" -- "1" Response
    
    Response "1" -- "0..*" DataSet
    Response "1" -- "0..*" Feedback

@enduml

