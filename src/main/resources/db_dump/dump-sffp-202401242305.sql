PGDMP     9                     |            sffp    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            	           1262    16398    sffp    DATABASE     x   CREATE DATABASE sffp WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE sffp;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false            
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
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
       public          postgres    false    215    4                       0    0    depositor_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.depositor_id_seq OWNED BY public.depositor.id;
          public          postgres    false    214            �            1259    16442 	   operation    TABLE     �   CREATE TABLE public.operation (
    id bigint NOT NULL,
    depositordonorid bigint NOT NULL,
    operationtype integer NOT NULL,
    changebalance numeric(38,2),
    operationdate timestamp without time zone,
    depositoracceptorid bigint NOT NULL
);
    DROP TABLE public.operation;
       public         heap    postgres    false    4            �            1259    16441    operation_id_seq    SEQUENCE     �   CREATE SEQUENCE public.operation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.operation_id_seq;
       public          postgres    false    217    4                       0    0    operation_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.operation_id_seq OWNED BY public.operation.id;
          public          postgres    false    216            j           2604    16406    depositor id    DEFAULT     l   ALTER TABLE ONLY public.depositor ALTER COLUMN id SET DEFAULT nextval('public.depositor_id_seq'::regclass);
 ;   ALTER TABLE public.depositor ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215            k           2604    16453    operation id    DEFAULT     l   ALTER TABLE ONLY public.operation ALTER COLUMN id SET DEFAULT nextval('public.operation_id_seq'::regclass);
 ;   ALTER TABLE public.operation ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216    217                      0    16400 	   depositor 
   TABLE DATA           0   COPY public.depositor (id, balance) FROM stdin;
    public          postgres    false    215   '                 0    16442 	   operation 
   TABLE DATA           {   COPY public.operation (id, depositordonorid, operationtype, changebalance, operationdate, depositoracceptorid) FROM stdin;
    public          postgres    false    217   [                  0    0    depositor_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.depositor_id_seq', 1, false);
          public          postgres    false    214                       0    0    operation_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.operation_id_seq', 19, true);
          public          postgres    false    216            m           2606    16408    depositor depositor_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.depositor
    ADD CONSTRAINT depositor_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.depositor DROP CONSTRAINT depositor_pkey;
       public            postgres    false    215            o           2606    16455    operation operation_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT operation_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.operation DROP CONSTRAINT operation_pkey;
       public            postgres    false    217            p           2606    16478    operation dep_acc_pk    FK CONSTRAINT     �   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT dep_acc_pk FOREIGN KEY (depositoracceptorid) REFERENCES public.depositor(id) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.operation DROP CONSTRAINT dep_acc_pk;
       public          postgres    false    3181    215    217            q           2606    16464 %   operation operation_depositor_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT operation_depositor_id_fkey FOREIGN KEY (depositordonorid) REFERENCES public.depositor(id) ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.operation DROP CONSTRAINT operation_depositor_id_fkey;
       public          postgres    false    3181    215    217               $   x�3�4143�30�2�4750 ��8M �=... g��           x�}���!гF�	|4��?�Ş���X^_��&������ڋ�%�R]��r�h6�8�\*4��QҏL���q��\��L�M��ɂ�N�9E�a\̋�f�d̬a�V�o���A�lȦ}6=47&�a%�P��� x�q�5�`�n.�P6���,���Ԇ.z�.T��X:�hi��^�xSpieĮjo��(�4��M��"�Ikx�uP��V���޶�ϩ߶b|��æG��m�T7ק
�m��
�]���C��_���:     