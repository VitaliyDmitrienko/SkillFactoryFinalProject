PGDMP     %    9                 |            sffp    15.3    15.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16398    sffp    DATABASE     x   CREATE DATABASE sffp WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE sffp;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    16400 	   depositor    TABLE     U   CREATE TABLE public.depositor (
    id bigint NOT NULL,
    balance numeric(38,2)
);
    DROP TABLE public.depositor;
       public         heap    postgres    false    4            �            1259    16399    depositor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.depositor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.depositor_id_seq;
       public          postgres    false    4    215            �           0    0    depositor_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.depositor_id_seq OWNED BY public.depositor.id;
          public          postgres    false    214            e           2604    16406    depositor id    DEFAULT     l   ALTER TABLE ONLY public.depositor ALTER COLUMN id SET DEFAULT nextval('public.depositor_id_seq'::regclass);
 ;   ALTER TABLE public.depositor ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            �          0    16400 	   depositor 
   TABLE DATA           0   COPY public.depositor (id, balance) FROM stdin;
    public          postgres    false    215   �                   0    0    depositor_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.depositor_id_seq', 1, false);
          public          postgres    false    214            g           2606    16408    depositor depositor_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.depositor
    ADD CONSTRAINT depositor_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.depositor DROP CONSTRAINT depositor_pkey;
       public            postgres    false    215            �       x�3�4400�30�2�4���9���=... d�h     