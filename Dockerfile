{\rtf1\ansi\ansicpg1252\cocoartf2818
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww28300\viewh14600\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 # Imagen base\
FROM openjdk:17-jdk-slim\
\
# Directorio de trabajo\
WORKDIR /app\
\
# Copia los archivos\
COPY build/libs/biblioteca-1.0.0.jar app.jar\
\
# Comando de ejecuci\'f3n\
ENTRYPOINT ["java", "-jar", "app.jar"]\
}